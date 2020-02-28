package com.huhuamin.starter.register.service.impl;


import com.huhuamin.execption.HuhuaminException;
import com.huhuamin.execption.HuhuaminExceptionPlan;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.mybatis.mapper.MapperPostProcessor;
import com.huhuamin.mybatis.type.handler.GeoPoint;
import com.huhuamin.req.constants.HhmConstants;
import com.huhuamin.req.json.result.JsonResult;
import com.huhuamin.service.Service;
import com.huhuamin.starter.register.RegisterProperties;
import com.huhuamin.starter.register.dao.mapper.CustomerMapper;
import com.huhuamin.starter.register.dao.model.Customer;
import com.huhuamin.starter.register.req.ReqLoginPhone;
import com.huhuamin.starter.register.service.IRegisterService;
import com.huhuamin.starter.register.utils.RedisSessionUtils;
import com.huhuamin.utils.UUIDUtils;
import com.huhuamin.validate.CommonValidate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 11:09
 * @Description:
 */
public class DefaultRegisterServiceImpl implements IRegisterService, MapperPostProcessor<ReqLoginPhone, JsonResult> {


    /**
     * 线程数据传递
     */
    private ThreadLocal<String> threadLocalTransfer = new ThreadLocal<>();

    public ThreadLocal<String> getThreadLocalTransfer() {
        return threadLocalTransfer;
    }

    private MapperPostProcessor delete;

    private JedisService jedisService;


    private RegisterProperties registerProperties;

    public DefaultRegisterServiceImpl(RegisterProperties registerProperties, JedisService jedisService) {
        this.registerProperties = registerProperties;
        this.jedisService = jedisService;
    }

    public DefaultRegisterServiceImpl() {
    }

    @Value("${off_line}")
    private boolean off_line;
    @Value("${server_name}")
    private String serverName;
    private GeoPoint geoPoint = new GeoPoint(new BigDecimal(116.3974700000d), new BigDecimal(39.9088230000d));

    @Override
    public JsonResult postProcessorBefore(ReqLoginPhone reqRegister, JsonResult jsonResult) {
        //默认的逻辑处理
        jsonResult = delete.postProcessorBefore(reqRegister, jsonResult);

        if (jsonResult.getStatusCode() && CommonValidate.checkDeviceId(reqRegister)) {
            //自己的业务逻辑处理
            //设备号校验
            if (StringUtils.isEmpty(reqRegister.getDeviceId())) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("设备号不能为空");
                return jsonResult;
            }
            //推送校验
            if (StringUtils.isEmpty(reqRegister.getPushId())) {
                //是否需要校验推送
                if (registerProperties.getCheckPushId().equals(RegisterProperties.NEED_PUSH)) {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("没有获取到你的推送标识");
                    return jsonResult;
                }
            }
        }
        String codeType = threadLocalTransfer.get();
        String serverPhone = jedisService.getValueByKey(codeType + reqRegister.getPhone() + HhmConstants.TARGET_NUMBER);
        if (null == serverPhone) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("验证码过期或未发送");
            return jsonResult;
        }
        //jedisService有没有过期判断
        RedisSessionUtils.handleSesseionValid(reqRegister.getPhone(), jsonResult, jedisService, off_line, codeType);
        if (!jsonResult.getStatusCode()) {
            return jsonResult;
        }
        //验证码正确性校验
        jsonResult = RedisSessionUtils.handlerPhone(serverPhone, reqRegister.getPhoneCode(), jedisService, codeType, off_line);
        return jsonResult;
    }

    @Override
    public JsonResult doService(CustomerMapper customerMapper, ReqLoginPhone reqRegister) {
        String prefix = "phone";
        String identifier = null;
        try {
            identifier = jedisService.acquireLock(prefix + reqRegister.getPhone());
            JsonResult jsonResult = new JsonResult(false);
            jsonResult = postProcessorBefore(reqRegister, jsonResult);
            if (!jsonResult.getStatusCode()) return jsonResult;

            doRegister(customerMapper, reqRegister);

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "注册";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        } finally {
            if (StringUtils.hasText(identifier)) {
                boolean flag = jedisService.releaseLock(prefix + reqRegister.getPhone(), identifier);
                if (!flag) {
                    throw new HuhuaminException("数据处理超时");
                }
            }
        }
    }


    @Override
    public JsonResult postProcessorAfter(ReqLoginPhone reqLoginPhone, JsonResult jsonResult) {
        return jsonResult;
    }

    /**
     * 注册
     *
     * @param reqRegister
     * @return
     */
    private void doRegister(CustomerMapper customerMapper, ReqLoginPhone reqRegister) {
        Date now = new Date();
        Customer customer = new Customer();
        String custId = UUIDUtils.generateUuid22();
        customer.setCustPhone(reqRegister.getPhone());
        if (null == reqRegister.getRegisterSource()) {
            customer.setRegistSource((byte) 1);
        } else {
            customer.setRegistSource(reqRegister.getRegisterSource().byteValue());
        }
        customer.setRegistTime(now);
        customer.setCustId(custId);
//        customer.setInviteCode(custId);
        customer.setCustType(reqRegister.getCustType().intValue());
        serverName = StringUtils.isEmpty(serverName) ? "胡化敏" : serverName;
        String nickName = serverName.concat(reqRegister.getPhone().substring(7, 11));
        customer.setNickName(nickName);
        customer.setInviteCode(custId);
        customer.setRegistTime(now);
        customer.setCustSex((byte) 3);
        customer.setFreezeStatus((byte) 4);
        customer.setInviterCode(reqRegister.getInviterCode());
        customer.setDelFlag((byte) 1);

        String img3 = customerMapper.selectDefaultImg("default_headimg");

        customer.setHeadImg(img3);

        customerMapper.insertSelective(customer);

//        try {
//            RongcloudUtil.registUser(customer.getCustId(), customer.getNickName(), "http://img.up-coach.com/" + customer.getHeadImg());
//        } catch (Exception e) {
//            throw new HuhuaminException("融云绑定失败");
//        }

    }


}

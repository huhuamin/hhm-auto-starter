package com.huhuamin.starter.register.service.impl;


import com.huhuamin.execption.HuhuaminException;
import com.huhuamin.execption.HuhuaminExceptionPlan;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.mybatis.mapper.MapperPostProcessor;
import com.huhuamin.mybatis.type.handler.GeoPoint;
import com.huhuamin.req.constants.HhmConstants;
import com.huhuamin.result.JsonResult;
import com.huhuamin.result.TypeJsonResult;
import com.huhuamin.starter.register.RegisterProperties;
import com.huhuamin.starter.register.dao.mapper.CustomerMapper;
import com.huhuamin.starter.register.dao.model.Customer;
import com.huhuamin.starter.register.req.ReqLoginPhone;
import com.huhuamin.starter.register.service.IRegisterService;
import com.huhuamin.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    private IRegisterService registerService;

    public DefaultRegisterServiceImpl(IRegisterService defaultRegisterService, RegisterProperties registerProperties, JedisService jedisService) {
        this.registerProperties = registerProperties;
        this.jedisService = jedisService;
        this.registerService = defaultRegisterService;
    }

    public DefaultRegisterServiceImpl() {
    }

    @Value("${off_line}")
    private boolean off_line;
    @Value("${server_name}")
    private String serverName;
    private GeoPoint geoPoint;

    @Override
    public JsonResult postProcessorBefore(ReqLoginPhone reqRegister, JsonResult jsonResult) {
        OnlyRegisterServiceImpl onlyRegisterService = (OnlyRegisterServiceImpl) registerService;
        return onlyRegisterService.postProcessorBefore(reqRegister, jsonResult);
    }

    @Override
    @Transactional
    public JsonResult doService(CustomerMapper customerMapper, ReqLoginPhone reqRegister) {
        String prefix = "doLoginPhone";
        String identifier = null;
        boolean register = RegisterProperties.DEFAULT_TYPE.equals(registerProperties.getRegisterType());
        try {
            identifier = jedisService.acquireLock(prefix + reqRegister.getPhone());
            TypeJsonResult<Customer> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            Customer customer = getByPhone(customerMapper, reqRegister.getPhone());
            if (customer == null && !register) {//短信默认登录没开启 未注册不能注册
                //如果没注册 需要注册 返回去注册
                typeJsonResult.setCode(310);
                typeJsonResult.setMessage("账号未注册请先注册");
                return typeJsonResult;
            }
            if (customer == null && register) {//短信默认登录开启 未注册 直接注册
                JsonResult jsonResult = registerService.doService(customerMapper, reqRegister);
                if (!jsonResult.getStatusCode()) {
                    typeJsonResult.setMessage(jsonResult.getMessage());
                    return typeJsonResult;
                }
                customer = getByPhone(customerMapper, reqRegister.getPhone());
                customer.setToken(UUIDUtils.genertateUuid32());
//                        appOpen(customer.getCustId());
                jedisService.refreshCustToken(customer.getCustId(), customer.getToken());
                refreshPushId(reqRegister, customer, customerMapper);
                typeJsonResult.setType(customer);
                typeJsonResult.setStatusCode(true);
                return typeJsonResult;
            }
            //登录成功 判断 是否被冻结
            if (freezeStatusCheck(typeJsonResult, customer)) return typeJsonResult;
            if (null != customer) {
                refreshPushId(reqRegister, customer, customerMapper);
                customer.setToken(UUIDUtils.genertateUuid32());
//                        appOpen(customer.getCustId());
                jedisService.refreshCustToken(customer.getCustId(), customer.getToken());
            }
            typeJsonResult.setType(customer);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "短信登录过程中";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        } finally {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(identifier)) {
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


    private Customer getByPhone(CustomerMapper customerMapper, String phone) {
        Customer query = new Customer();
        query.setCustPhone(phone);
        List<Customer> list = customerMapper.selectSelective(query);
        if (null == list) {
            return null;
        }
        if (list.size() > 0) {
            throw new HuhuaminException("系统手机号存在重复");
        }
        return list.stream().findFirst().orElse(null);
    }

    /**
     * 权限已被冻结
     *
     * @param typeJsonResult
     * @param customer
     * @return
     */
    private boolean freezeStatusCheck(TypeJsonResult<Customer> typeJsonResult, Customer customer) {
        if (null != customer && customer.getFreezeStatus().intValue() == 3) {
            // 未查询到账号
            typeJsonResult.setStatusCode(false);
            typeJsonResult.setCode(304);
            typeJsonResult.setMessage("无使用权限，注:您的使用权限已被冻结，请联系客服");
            return true;
        }
        return false;
    }

    private void refreshPushId(ReqLoginPhone reqRegister, Customer customer, CustomerMapper customerMapper) {
        OnlyRegisterServiceImpl onlyRegisterService = (OnlyRegisterServiceImpl) registerService;
        onlyRegisterService.refreshPushId(reqRegister, customer, customerMapper);
    }


}

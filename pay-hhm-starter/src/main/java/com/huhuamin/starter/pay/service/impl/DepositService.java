package com.huhuamin.starter.pay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.huhuamin.execption.HuhuaminException;
import com.huhuamin.execption.HuhuaminExceptionPlan;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.mybatis.mapper.HhmPostProcessor;
import com.huhuamin.mybatis.mapper.MapperDb;
import com.huhuamin.result.TypeJsonResult;
import com.huhuamin.starter.customer.dao.mapper.CustomerMapper;
import com.huhuamin.starter.pay.ali.AliPayProperties;
import com.huhuamin.starter.pay.dao.mapper.DepoistMapper;
import com.huhuamin.starter.pay.dao.model.Depoist;
import com.huhuamin.starter.pay.req.ReqPayDeposit;
import com.huhuamin.starter.pay.resp.RespPayWxJson;
import com.huhuamin.starter.pay.wechat.HhmWechatPayService;
import com.huhuamin.starter.pay.wechat.WxPayProperties;
import com.huhuamin.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/6 23:45
 * @Description:
 */
public class DepositService {
    private HhmPostProcessor delegate;
    private JedisService jedisService;
    private AliPayProperties aliPayProperties;
    private WxPayProperties wxPayProperties;
    private HhmWechatPayService hhmWechatPayService;


    public DepositService(HhmPostProcessor delegate, JedisService jedisService, AliPayProperties aliPayProperties, WxPayProperties wxPayProperties, HhmWechatPayService hhmWechatPayService) {
        this.jedisService = jedisService;
        this.aliPayProperties = aliPayProperties;
        this.wxPayProperties = wxPayProperties;
        this.hhmWechatPayService = hhmWechatPayService;
        this.delegate = delegate;

    }

    @Transactional

    public TypeJsonResult doService(DepoistMapper depoistMapper, ReqPayDeposit reqSource, List<MapperDb> list) {
        String prefix = "doDeposit";
        String identifier = null;
        try {
            identifier = jedisService.acquireLock(prefix + reqSource.getTokenCustId());
            TypeJsonResult typeJsonResult = new TypeJsonResult();
            //需要交保证金
            Date now = new Date();
            Depoist depoist = null;
            String orderNo = UUIDUtils.generateUuid22();
            CustomerMapper customerMapper = (CustomerMapper) list.get(0);
            byte custType = customerMapper.selectCustTypeByCustId(reqSource.getTokenCustId());
            depoist = initDepoist(orderNo, reqSource.getTokenCustId(), custType, now);
            String body = "交保证金:" + depoist.getOrderAmt();
            //orderSource	tinyint(1)	支付方式[1-支付宝 2-微信]
            depoist.setOrderSource(reqSource.getOrderSource());
            if (reqSource.getOrderSource().intValue() == 1) {
//实例化客户端
                AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", aliPayProperties.getAppId(), aliPayProperties.getPrivateKey(), "json", "UTF-8", aliPayProperties.getPublicKey(), "RSA2");
                //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
                AlipayTradeAppPayRequest requestA = new AlipayTradeAppPayRequest();
                //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
                AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

                model.setBody(body);
                model.setSubject(body);
                model.setOutTradeNo(depoist.getOrderNo());
                model.setTimeoutExpress("30m");
                model.setTotalAmount(BizUtils.saveTwoPoint(Arith.div(depoist.getOrderAmt(), 1, 2)));
                model.setProductCode("QUICK_MSECURITY_PAY");
                requestA.setBizModel(model);
                requestA.setNotifyUrl(aliPayProperties.getDepositUrl());
                //这里和普通的接口调用不同，使用的是sdkExecute
                AlipayTradeAppPayResponse responseA = alipayClient.sdkExecute(requestA);
                typeJsonResult.setPayJson(responseA.getBody());
            } else if (reqSource.getOrderSource() == 2) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = new WxPayUnifiedOrderRequest();
                wxPayUnifiedOrderRequest.setVersion("1.0");
                wxPayUnifiedOrderRequest.setBody(body);
                wxPayUnifiedOrderRequest.setAttach(body);
                wxPayUnifiedOrderRequest.setOutTradeNo(depoist.getOrderNo());
                wxPayUnifiedOrderRequest.setTotalFee(Double.valueOf(Arith.mul(depoist.getOrderAmt(), 100)).intValue());
                wxPayUnifiedOrderRequest.setSpbillCreateIp(WebServletUtil.getClientIpAddr(request));
                wxPayUnifiedOrderRequest.setNotifyUrl(wxPayProperties.getDepositUrl());
                WxPayAppOrderResult wxPayAppOrderResult = hhmWechatPayService.createOrderWxApp(wxPayUnifiedOrderRequest);
                RespPayWxJson respPayWxJson = new RespPayWxJson();
                RespPayWxJson.jsonConvert(respPayWxJson, wxPayAppOrderResult);
                typeJsonResult.setPayJson(respPayWxJson);
            }
            depoistMapper.insertSelective(depoist);


            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        } finally {
            if (StringUtils.isNotEmpty(identifier)) {
                boolean flag = jedisService.releaseLock(prefix + reqSource.getTokenCustId(), identifier);
                if (!flag) {
                    throw new HuhuaminException("数据处理超时");
                }
            }
        }

    }


    public TypeJsonResult doService(DepoistMapper depoistMapper, ReqPayDeposit reqSource) {
        return doService(depoistMapper, reqSource, null);
    }

    /**
     * 初始化履约保证金
     *
     * @param orderNo
     * @return
     */
    private Depoist initDepoist(String orderNo, String custId, byte custType, Date now) {
        Depoist depoist = new Depoist();
        //属性	类型	备注
        //depositId	char(32)	主键
        //depositType	tinyint(1)	保证金类别[1-雇主 2-工人]
        //custId	char(32)	客户ID
        //orderNo	varchar(255)	订单编号
        //serialNo	varchar(255)	流水号
        //orderAmt	double(11,2)	保证金金额

        //addTime	datetime	添加时间
        //effectyTime	datetime	保证金有效时间
        //depositStatus	tinyint(4)	付款状态[1-待付款 2-已付款 3-已退款 4-退款异常]
        //refundNo	varchar(255)	退款订单号
        //refundTime	datetime	退款时间
        //refundAmt	double(11,2)	退款金额
        //refundDesc	varchar(255)	退款描述

        depoist.setDepositId(UUIDUtils.generateUuid22());
        depoist.setDepositType(custType);
        depoist.setCustId(custId);
        depoist.setOrderNo(orderNo);
        //TODO from db
        depoist.setOrderAmt(200.00d);
        depoist.setAddTime(now);

        LocalDateTime localDateTime = DateUtils.date2LocalDateTime(now);

        LocalDateTime effectiveTime = LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 23, 59, 0);
        if (localDateTime.isBefore(effectiveTime)) {
            depoist.setEffectyTime(DateUtils.localDateTime2Date(effectiveTime));
        } else {
            depoist.setEffectyTime(DateUtils.localDateTime2Date(effectiveTime.plusDays(1)));
        }
        return depoist;
    }
}

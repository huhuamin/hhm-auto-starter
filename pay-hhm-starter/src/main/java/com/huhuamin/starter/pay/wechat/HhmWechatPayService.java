package com.huhuamin.starter.pay.wechat;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayOrderQueryRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.huhuamin.result.JsonResult;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/27 08:55
 * @Description: 微信支付
 */

public class HhmWechatPayService {
    private WxPayService wxService;

    public HhmWechatPayService(WxPayService wxService) {
        this.wxService = wxService;
    }


    /**
     * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
     * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
     * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
     *
     * @param request 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
     */
    public WxPayAppOrderResult createOrderWxApp(WxPayUnifiedOrderRequest request) throws WxPayException {
        request.setTradeType(WxPayConstants.TradeType.APP);
        return this.wxService.createOrder(request);
    }

    /**
     * 支付回调通知处理
     *
     * @param xmlData
     * @return
     * @throws WxPayException
     */
    public WxPayOrderNotifyResult parseOrderNotifyResult(String xmlData) throws WxPayException {
        WxPayOrderNotifyResult notifyResult = this.wxService.parseOrderNotifyResult(xmlData);
        return notifyResult;

    }

    /**
     * 订单查询
     *
     * @param request
     * @return
     * @throws WxPayException
     */
    public WxPayOrderQueryResult queryOrder(WxPayOrderQueryRequest request) throws WxPayException {
        return this.wxService.queryOrder(request);

    }

    public static String buildWxParam(InputStream inputStream, Logger logger) throws IOException {
        // 从输入流读取返回内容
        InputStreamReader inputStreamReader = null;
        inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        // 释放资源
        bufferedReader.close();
        inputStreamReader.close();
        String xml = buffer.toString();
        logger.info("微信支付回调返回值：" + xml);
        return xml;
    }

    public static void returnWx(HttpServletResponse response, JsonResult jsonResult) throws IOException {
        if (jsonResult.getStatusCode()) {
            response.setContentType("text/xml");
            String result = WxPayNotifyResponse.success("OK");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(result);
        } else {
            String result = WxPayNotifyResponse.fail("FAIL");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(result);
        }
    }


}

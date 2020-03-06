package com.huhuamin.starter.sms.exteral.sy;

import com.huhuamin.starter.sms.Sms;

import com.huhuamin.starter.sms.exteral.yzx.sdk.ReqSendMessage;


/**
 * @Auther: Huhuamin
 * @Date: 2020/3/4 12:33
 * @Description:
 */
public class SySmsClient implements Sms {

    private SySmsProperties sySmsProperties;
    private JsonReqClient jsonReqClient;

    public SySmsClient(JsonReqClient jsonReqClient, SySmsProperties sySmsProperties) {
        this.sySmsProperties = sySmsProperties;
        this.jsonReqClient=jsonReqClient;
    }

    @Override
    public String sendSms(ReqSendMessage reqSendMessage) {
        return jsonReqClient.sendSms(sySmsProperties.getAppKey(), sySmsProperties.getAppId(), reqSendMessage.getContentTempLate(), reqSendMessage.getParams(), reqSendMessage.getTarget());
    }
}

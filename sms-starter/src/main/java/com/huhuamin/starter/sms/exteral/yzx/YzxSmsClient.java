package com.huhuamin.starter.sms.exteral.yzx;


import com.huhuamin.starter.sms.Sms;
import com.huhuamin.starter.sms.exteral.yzx.sdk.JsonReqClient;
import com.huhuamin.starter.sms.exteral.yzx.sdk.ReqSendMessage;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/26 16:42
 * @Description: 云之讯发送短信 文档 http://docs.ucpaas.com/doku.php?id=%E7%9F%AD%E4%BF%A1:sendsms
 */
public class YzxSmsClient implements Sms {
    /**
     * 云之讯提供的工具类
     */
    private JsonReqClient jsonReqClient;
    /**
     * 云之讯的验证信息
     */
    private YzxSmsProperties yzxSmsProperties;

    public YzxSmsClient(JsonReqClient jsonReqClient, YzxSmsProperties yzxSmsProperties) {
        this.jsonReqClient = jsonReqClient;
        this.yzxSmsProperties = yzxSmsProperties;
    }

    public YzxSmsClient() {

    }

    public String sendSms(ReqSendMessage reqSendMessage) {
        try {
            String result = jsonReqClient.sendSms(yzxSmsProperties.getSid(), yzxSmsProperties.getToken(), yzxSmsProperties.getAppId(), reqSendMessage.getContentTempLate(), reqSendMessage.getParams(), reqSendMessage.getTarget(), "");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


}

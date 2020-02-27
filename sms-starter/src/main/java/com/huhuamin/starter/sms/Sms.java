package com.huhuamin.starter.sms;

import com.huhuamin.starter.sms.exteral.yzx.sdk.ReqSendMessage;

@FunctionalInterface
/**
 * 发送短信接口
 */
public interface Sms {
    /**
     * 发送短息
     *
     * @param reqSendMessage
     * @return
     */
    String sendSms(ReqSendMessage reqSendMessage);
}

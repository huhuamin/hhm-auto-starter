package com.huhuamin.starter.sms.exteral.yzx.sdk;

/**
 * 发送短信实体
 */
public class ReqSendMessage {


    public ReqSendMessage(String target, String contentTempLate, String params) {
        this.target = target;
        this.contentTempLate = contentTempLate;

        this.params = params;
    }

    public ReqSendMessage() {
    }

    /**
     * 目标手机号
     */
    private String target;
    /**
     * 模板id或者内容
     */
    private String contentTempLate;

    /**
     * 验证码 或者参数 多个逗号分隔
     */
    private String params;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContentTempLate() {
        return contentTempLate;
    }

    public void setContentTempLate(String contentTempLate) {
        this.contentTempLate = contentTempLate;
    }


}

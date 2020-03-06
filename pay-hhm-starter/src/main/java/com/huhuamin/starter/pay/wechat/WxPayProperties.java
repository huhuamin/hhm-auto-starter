package com.huhuamin.starter.pay.wechat;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/7 00:15
 * @Description:
 */
public class WxPayProperties {
    /**
     * 保证金支付回调
     */
    private String depositUrl;

    public String getDepositUrl() {
        return depositUrl;
    }

    public void setDepositUrl(String depositUrl) {
        this.depositUrl = depositUrl;
    }

    /**
     * appId
     */
    private String appId;
    /**
     * 开放平台秘钥
     */
    private String appSecret;
    /**
     * 支付秘钥
     */
    private String payAppSecret;
    /**
     * 商户号
     */
    private String mchId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getPayAppSecret() {
        return payAppSecret;
    }

    public void setPayAppSecret(String payAppSecret) {
        this.payAppSecret = payAppSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }
}

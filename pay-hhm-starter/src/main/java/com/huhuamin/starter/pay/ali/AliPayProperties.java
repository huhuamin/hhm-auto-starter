package com.huhuamin.starter.pay.ali;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/7 00:15
 * @Description:
 */
@ConfigurationProperties(prefix = "spring.ali")
public class AliPayProperties {

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

    private String appId;
    private String privateKey;
    private String publicKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}

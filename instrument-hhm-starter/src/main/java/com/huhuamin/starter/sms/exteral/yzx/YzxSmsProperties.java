package com.huhuamin.starter.sms.exteral.yzx;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 14:35
 * @Description: 云之讯元数据配置
 * 文档 http://docs.ucpaas.com/doku.php?id=%E7%9F%AD%E4%BF%A1:sendsms
 */
@ConfigurationProperties(prefix = "spring.sms.yzx")
public class YzxSmsProperties {

    /**
     * 用户的账号唯一标识“Account Sid”，在开发者控制台获取
     */
    private String appId;
    /**
     * 创建应用时系统分配的唯一标示
     */
    private String sid;
    /**
     * 用户密钥“Auth Token”，在开发者控制台获取
     */
    private String token;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.huhuamin.starter.fdb.aliyun;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/5 14:53
 * @Description:
 */
@ConfigurationProperties(prefix = "spring.fdb.aliyun")
public class AliyunCosProperties {

    private String endpoint;
    private String accessKeyId;
    private String secret;
    private String buckName;

    public String getBuckName() {
        return buckName;
    }

    public void setBuckName(String buckName) {
        this.buckName = buckName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}

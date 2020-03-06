package com.huhuamin.starter.sms.exteral.alibaba;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 14:35
 * @Description: 阿里云元数据配置
 * 文档 https://help.aliyun.com/document_detail/56189.html?spm=a2c4g.11186623.3.2.3d4637ed3u6dpB
 */
@ConfigurationProperties(prefix = "spring.sms.alibaba")
public class AlibabaSmsProperties {
    /**
     *
     */
    private String regionId = "default";
    /**
     * 你的accessKeyId
     */
    private String accessKeyId;
    /**
     * 你的accessKeySecret
     */
    private String secret;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
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

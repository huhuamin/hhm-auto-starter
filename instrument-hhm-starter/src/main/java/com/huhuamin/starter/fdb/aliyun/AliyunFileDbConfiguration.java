package com.huhuamin.starter.fdb.aliyun;

import com.aliyun.oss.OSSClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/5 15:01
 * @Description:
 */
@Configuration
public class AliyunFileDbConfiguration {


    @Bean
    @ConditionalOnProperty(name = "spring.filedb.aliyun.enabled", havingValue = "true", matchIfMissing = false)
    public OSSClient ossClient(AliyunCosProperties aliyunCosProperties) {
        OSSClient ossClient = new OSSClient(aliyunCosProperties.getEndpoint(), aliyunCosProperties.getAccessKeyId(), aliyunCosProperties.getSecret());
        return ossClient;
    }

    @Bean
    @ConditionalOnProperty(name = "spring.filedb.aliyun.enabled", havingValue = "true", matchIfMissing = false)
    public FdbAliyunService fdbAliyunService(AliyunCosProperties aliyunCosProperties, OSSClient ossClient) {
        return new FdbAliyunService(aliyunCosProperties, ossClient);
    }


}

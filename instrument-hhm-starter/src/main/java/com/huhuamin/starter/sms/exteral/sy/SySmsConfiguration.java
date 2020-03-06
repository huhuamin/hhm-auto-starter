package com.huhuamin.starter.sms.exteral.sy;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 14:49
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class SySmsConfiguration {

    @Bean
    @ConditionalOnProperty(name = "spring.sms.sy.enabled", havingValue = "true", matchIfMissing = false)
    public SySmsClient sySmsClient(SySmsProperties sySmsProperties) {
        return new SySmsClient(jsonReqClient(), sySmsProperties);
    }


    @Bean
    @ConditionalOnProperty(name = "spring.sms.sy.enabled", havingValue = "true", matchIfMissing = false)
    public JsonReqClient jsonReqClient() {
        return new JsonReqClient();
    }
}

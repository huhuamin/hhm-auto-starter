package com.huhuamin.starter.sms.exteral.yzx;


import com.huhuamin.starter.sms.exteral.yzx.sdk.JsonReqClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 14:49
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class YzxSmsConfiguration {

    @Bean
    @ConditionalOnProperty(name = "spring.sms.yzx.enabled", havingValue = "true", matchIfMissing = false)
    public YzxSmsClient yzxSmsClient(YzxSmsProperties yzxSmsProperties) {
        JsonReqClient jsonReqClient = new JsonReqClient();
        return new YzxSmsClient(jsonReqClient, yzxSmsProperties);
    }

}

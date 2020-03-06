package com.huhuamin.starter.sms.exteral.alibaba;

import com.huhuamin.starter.sms.exteral.alibaba.AlibabaSmsClient;
import com.huhuamin.starter.sms.exteral.alibaba.AlibabaSmsProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 14:49
 * @Description: 阿里巴巴短信自动配置类
 */
@Configuration(proxyBeanMethods = false)
public class AlibabaSmsConfiguration {

    @Bean
    @ConditionalOnProperty(name = "spring.sms.alibaba.enabled", havingValue = "true", matchIfMissing = false)
    public AlibabaSmsClient alibabaSmsClient(AlibabaSmsProperties alibabaSmsProperties) {
        return new AlibabaSmsClient(alibabaSmsProperties);
    }

}

package com.huhuamin.starter.register;


import com.huhuamin.jedis.distributed.lock.JedisDistributedLockAutoConfiguration;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.starter.register.service.IRegisterService;
import com.huhuamin.starter.register.service.impl.DefaultRegisterServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 20:22
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(JedisDistributedLockAutoConfiguration.class)
@EnableConfigurationProperties({RegisterProperties.class})
@ConditionalOnProperty(name = {"spring.jedis.lock.enabled", "spring.register.enabled"}, havingValue = "true", matchIfMissing = false)
public class RegisterStarterAutoConfiguration {


    /**
     * 默认实现 default 登录 注册
     *
     * @return
     */
    @ConditionalOnMissingBean(IRegisterService.class)
    @Bean
    public IRegisterService registerService(RegisterProperties registerProperties, JedisService jedisService) {
        return new DefaultRegisterServiceImpl(registerProperties, jedisService);

    }
}

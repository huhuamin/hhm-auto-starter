package com.huhuamin.starter.register;


import com.huhuamin.jedis.distributed.lock.JedisDistributedLockAutoConfiguration;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.mybatis.mapper.DefaultMapperPostProcessor;
import com.huhuamin.mybatis.mapper.MapperPostProcessor;
import com.huhuamin.mybatis.type.handler.GeoPoint;
import com.huhuamin.starter.register.service.IRegisterService;
import com.huhuamin.starter.register.service.impl.OnlyRegisterServiceImpl;
import com.huhuamin.starter.register.service.impl.DefaultRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 20:22
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(JedisDistributedLockAutoConfiguration.class)
@EnableConfigurationProperties({RegisterProperties.class})
@ConditionalOnProperty(name = {"spring.jedis.lock.enabled", "spring.register.enabled"}, havingValue = "true", matchIfMissing = false)
public class RegisterAutoConfiguration {
    public static String BEAN_NAME_ONLY_REGISTER_SERVICE = "onlyRegisterService";
    public static String BEAN_NAME_DEFAULT_REGISTER_SERVICE = "defaultRegisterService";
    @Value("${off_line}")
    private boolean off_line;
    @Value("${server_name}")
    private String serverName;

    @Bean
    public MapperPostProcessor mapperPostProcessor() {
        return new DefaultMapperPostProcessor();
    }

    //    默认 背景天安门
    @Bean
    public GeoPoint geoPoint() {
        return new GeoPoint(new BigDecimal(116.3974700000d), new BigDecimal(39.9088230000d));
    }

    /**
     * 仅仅是注册
     *
     * @return
     */
    @Bean("onlyRegisterService")
    public IRegisterService onlyRegisterService(RegisterProperties registerProperties, JedisService jedisService) {
        return new OnlyRegisterServiceImpl(off_line,serverName,geoPoint(), mapperPostProcessor(), registerProperties, jedisService);
    }

    /**
     * 默认实现 default 登录 注册
     *
     * @param registerProperties
     * @param jedisService
     * @return
     */
    @Bean("defaultRegisterService")
    public IRegisterService defaultRegisterService(RegisterProperties registerProperties, JedisService jedisService) {
        return new DefaultRegisterServiceImpl(onlyRegisterService(registerProperties, jedisService), registerProperties, jedisService);

    }
}

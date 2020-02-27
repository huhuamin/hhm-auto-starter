package com.huhuamin.jedis.distributed.lock;

import com.huhuamin.jedis.distributed.lock.service.JedisService;
import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 21:29
 * @Description: redis 分布式 及redis 字符存储操作
 */

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = "spring.jedis.lock.enabled", havingValue = "true", matchIfMissing = false)
public class JedisDistributedLockAutoConfiguration {

    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private Integer redisPort;
    @Value("${spring.redis.password}")
    private String redisPwd;
    @Value("${spring.redis.db.prefix}")
    private String dbPrefix;

    @Bean
    public JedisService jedisService() {
        if (StringUtils.isEmpty(dbPrefix)) {
            return new JedisService(jedisPool());
        } else {
            return new JedisService(jedisPool(), dbPrefix);
        }
    }

    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisHost);
        redisManager.setPort(redisPort);
        redisManager.setExpire(36000);// 配置缓存过期时间
        redisManager.setTimeout(0);
        redisManager.setPassword(redisPwd);
        //./bin/redis-cli -h 172.21.16.14 -p 6380 -a HUHUAMIN@423177
//        redisManager.setPassword("HUHUAMIN@423177");
        return redisManager;
    }


    /**
     * 初始化方法
     */
    @Bean
    public JedisPool jedisPool() {
        RedisManager redisManager = redisManager();
        if (redisManager.getPassword() != null && !"".equals(redisManager.getPassword())) {
            return new JedisPool(new JedisPoolConfig(), redisManager.getHost(), redisManager.getPort(), redisManager.getTimeout(), redisManager.getPassword());
        } else if (redisManager.getTimeout() != 0) {
            return new JedisPool(new JedisPoolConfig(), redisManager.getHost(), redisManager.getPort(), redisManager.getTimeout());
        } else {
            return new JedisPool(new JedisPoolConfig(), redisManager.getHost(), redisManager.getPort());
        }

    }

}

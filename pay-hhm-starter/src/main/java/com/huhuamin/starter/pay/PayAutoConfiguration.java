package com.huhuamin.starter.pay;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.huhuamin.jedis.distributed.lock.JedisDistributedLockAutoConfiguration;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.mybatis.mapper.HhmPostProcessor;
import com.huhuamin.starter.pay.ali.AliPayProperties;
import com.huhuamin.starter.pay.service.impl.DepositService;
import com.huhuamin.starter.pay.wechat.HhmWechatPayService;
import com.huhuamin.starter.pay.wechat.WxPayProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/6 23:38
 * @Description:
 */
@Configuration
@AutoConfigureAfter(JedisDistributedLockAutoConfiguration.class)
@EnableConfigurationProperties({WxPayProperties.class, AliPayProperties.class})
public class PayAutoConfiguration {

    @Bean
    public WxPayService wxPayService(WxPayProperties wxPayProperties) {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(StringUtils.trimToNull(wxPayProperties.getAppId()));
        payConfig.setMchId(StringUtils.trimToNull(wxPayProperties.getMchId()));
        payConfig.setMchKey(StringUtils.trimToNull(wxPayProperties.getPayAppSecret()));
        // 可以指定是否使用沙箱环境
        payConfig.setUseSandboxEnv(false);

        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }

    @Bean
    public HhmWechatPayService wechatPayService(WxPayService wxPayService) {
        return new HhmWechatPayService(wxPayService);
    }

    @Bean
    public DepositService depositService(HhmPostProcessor hhmPostProcessor, HhmWechatPayService hhmWechatPayService, WxPayProperties wxPayProperties, AliPayProperties aliPayProperties, JedisService jedisService) {
        return new DepositService(hhmPostProcessor, jedisService, aliPayProperties, wxPayProperties, hhmWechatPayService);
    }


}

package com.huhuamin.starter.sms;

import com.huhuamin.starter.sms.exteral.alibaba.AlibabaSmsConfiguration;
import com.huhuamin.starter.sms.exteral.alibaba.AlibabaSmsProperties;
import com.huhuamin.starter.sms.exteral.sy.SySmsConfiguration;
import com.huhuamin.starter.sms.exteral.sy.SySmsProperties;
import com.huhuamin.starter.sms.exteral.yzx.YzxSmsConfiguration;
import com.huhuamin.starter.sms.exteral.yzx.YzxSmsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/27 13:45
 * @Description:短信发送自动装配 用2个模块
 * 阿里云的短信{@link com.huhuamin.starter.sms.exteral.alibaba.AlibabaSmsClient} 发送短息
 * 云之讯的 {@link com.huhuamin.starter.sms.exteral.yzx.YzxSmsClient} 发送短信
 * 赛又 {@link com.huhuamin.starter.sms.exteral.sy.SySmsProperties} 发送短信
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({YzxSmsProperties.class, AlibabaSmsProperties.class, SySmsProperties.class})
@Import({YzxSmsConfiguration.class, AlibabaSmsConfiguration.class, SySmsConfiguration.class})
public class SmsAutoConfiguration {

}

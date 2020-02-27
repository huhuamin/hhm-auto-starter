package com.clzah.autodemo;

import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.starter.sms.exteral.alibaba.AlibabaSmsClient;
import com.huhuamin.starter.sms.exteral.yzx.YzxSmsClient;
import com.huhuamin.starter.sms.exteral.yzx.sdk.ReqSendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.huhuamin")
public class AutodemoApplication implements ApplicationRunner {

    @Autowired
    private YzxSmsClient yzxSmsClient;
    @Autowired
    private AlibabaSmsClient alibabaSmsClient;
    @Autowired
    private JedisService jedisService;

    public static void main(String[] args) {
        SpringApplication.run(AutodemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ReqSendMessage reqSendMessage = new ReqSendMessage();
        reqSendMessage.setContentTempLate("524236");//模板id
        reqSendMessage.setParams("888111");//参数
        reqSendMessage.setTarget("13349118678");//手机号
        String result = yzxSmsClient.sendSms(reqSendMessage);
        System.out.println(result);
        reqSendMessage.setContentTempLate("SMS_155270122");//模板id
        result = alibabaSmsClient.sendSms(reqSendMessage);
        System.out.println(result);
        jedisService.setKeyValue("huhuamin", "tttt", 1000);
        System.out.println(jedisService.getValueByKey("huhuamin"));


    }
}

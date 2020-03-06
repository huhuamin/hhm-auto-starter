#短信自动装配模块
##1.引入pom
###1.1先自己下载源码 sms-starter 执行
```shell script
mvn clean install 
```
### 1.2 使用http://start.spring.io 创建一个项目，然后pom 引入
```xml
   <dependency>
            <groupId>com.huhuamin</groupId>
            <artifactId>instrument-hhm-spring-boot-starter</artifactId>
            <version>1.0-SNAPSHOT</version>
    </dependency>
```
##2.增加properties
```properties
#放开云之讯
spring.sms.yzx.enabled=true
spring.sms.yzx.appId=b1ef144b39204ac4be2db2afa57xxxx
spring.sms.yzx.sid=30085fd8a5f9b5eccdeebc405e79xxxx
spring.sms.yzx.token=51a64edce84fbcb1bbe5eb3d65a9xxxx

#放开阿里巴巴短信 旧版
spring.sms.alibaba.enabled=true
spring.sms.alibaba.accessKeyId=LTAIxwpfltO8xxxx
spring.sms.alibaba.secret=qhdAkf9fRGwF8iEgQGVT0xUU10xxxx

```
##3.调用实例
```java
package com.clzah.autodemo;

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

    }
}

```

##4.说明
目前只提供  阿里云短信旧版 云之讯
尊敬的用户：您的短信验证码为：{1}，切勿告知他人！
一个参数，一个手机号模板消息
可以自己增加 com.huhuamin.starter.sms.Sms 接口方法，及实现
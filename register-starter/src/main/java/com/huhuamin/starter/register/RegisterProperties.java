package com.huhuamin.starter.register;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 11:53
 * @Description:
 */
@ConfigurationProperties(prefix = "spring.register")
public class RegisterProperties {
    public static String DEFAULT_TYPE = "default";
    public static String NEED_PUSH = "push";
    public static String REGISTER = "register";

    /**
     * default默认注册登录
     * <p>
     * register 仅仅是注册
     */
    private String registerType = "default";
    /**
     * 默认不校验极光id pushID
     * <p>
     * 如说校验 checkPushId=push 且 目前只支持校验ios 和安卓
     */
    private String checkPushId = "default";

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getCheckPushId() {
        return checkPushId;
    }

    public void setCheckPushId(String checkPushId) {
        this.checkPushId = checkPushId;
    }
}

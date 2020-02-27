package com.huhuamin.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 公共业务模块
 */
public class ReqComm {
    /**
     * 设备id
     */
    @NotNull(message = "deviceId不能为空")
    private String deviceId;
    /**
     * 时间戳
     */
    private long timestamp;
    /**
     * 注册来源[1-微信 2-WAP 3-Android 4-iOS 5-pc 6-手动创建 7-小程序]
     */
    ///来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
    @NotNull(message = "registerSource不能为空")
    @Range(min = 1, max = 5, message = "registerSource范围是1-7")
    private Byte registerSource;

    private String tokenCustId;

    public String getTokenCustId() {
        return tokenCustId;
    }

    public void setTokenCustId(String tokenCustId) {
        this.tokenCustId = tokenCustId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * 来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
     *
     * @return
     */
    public Byte getRegisterSource() {
        return registerSource;
    }

    /**
     * 来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
     *
     * @param registerSource
     */
    public void setRegisterSource(Byte registerSource) {
        this.registerSource = registerSource;
    }
}

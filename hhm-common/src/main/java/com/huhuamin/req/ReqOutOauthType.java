package com.huhuamin.req;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/6 15:19
 * @Description:
 */
public class ReqOutOauthType extends ReqToken {


    private String openId;

    private String accessToken;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 1-微信 2-qq 3-微博 4-ios
     */
    //1-微信 2-qq 3-微博
    @NotNull(message = "第三方类型不能为空")
    private Byte regType;

    public Byte getRegType() {
        return regType;
    }

    public void setRegType(Byte regType) {
        this.regType = regType;
    }
}

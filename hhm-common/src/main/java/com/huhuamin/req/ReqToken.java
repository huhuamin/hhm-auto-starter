package com.huhuamin.req;

import javax.validation.constraints.NotBlank;

public class ReqToken extends ReqComm {
    /**
     * 平台token
     */
    @NotBlank(message = "token不能为空")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

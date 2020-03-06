package com.huhuamin.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * 发送短信验证码校验
 */
public class ReqForgetPwdCode extends ReqTokenIf {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式不正确")
    private String phone;
    /**
     * 图文验证码
     */
//    @NotEmpty(message = "图文验证码不能为空")
    private String imgCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }
}

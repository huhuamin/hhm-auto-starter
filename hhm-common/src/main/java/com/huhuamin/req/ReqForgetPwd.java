package com.huhuamin.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * 忘记密码修改
 */
public class ReqForgetPwd extends ReqComm {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式不正确")
    private String phone;
    @NotBlank(message = "请填写验证码")
    private String phoneCode;
    @NotBlank(message = "新密码不能为空")
    private String newPwd;
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

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}

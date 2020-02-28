package com.huhuamin.starter.register.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


import com.huhuamin.req.ReqComm;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * 登录
 */
public class ReqLoginPhone extends ReqComm {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式不正确")
    private String phone;
    @NotBlank(message = "请填写验证码")
    private String phoneCode;

    private String pushId;

    @NotNull(message = "custType不能为空")
    @Range(min = 1, max = 5, message = "custType范围是[1-雇主 2-工人]")
    private Byte custType;

    public Byte getCustType() {
        return custType;
    }

    public void setCustType(Byte custType) {
        this.custType = custType;
    }

    private String inviterCode;

    public String getInviterCode() {
        return inviterCode;
    }

    public void setInviterCode(String inviterCode) {
        this.inviterCode = inviterCode;
    }

    /**
     * 图文验证码
     */
//    @NotEmpty(message = "图文验证码不能为空")
    private String imgCode;

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

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

}

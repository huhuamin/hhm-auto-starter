package com.huhuamin.starter.pay.resp;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/27 18:45
 * @Description:
 */
public class RespPayWxJson {
    private String appid;

    private String partnerid;

    private String prepayid;

    @JSONField(name = "package")
    private String package_;

    private String noncestr;

    private String timestamp;

    private String sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getPackage_() {
        return package_;
    }

    public void setPackage_(String package_) {
        this.package_ = package_;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static void jsonConvert(RespPayWxJson respPayWxJson, WxPayAppOrderResult wxPayAppOrderResult) {
        respPayWxJson.setAppid(wxPayAppOrderResult.getAppId());
        respPayWxJson.setNoncestr(wxPayAppOrderResult.getNonceStr());
        respPayWxJson.setPackage_(wxPayAppOrderResult.getPackageValue());
        respPayWxJson.setPartnerid(wxPayAppOrderResult.getPartnerId());
        respPayWxJson.setPrepayid(wxPayAppOrderResult.getPrepayId());
        respPayWxJson.setSign(wxPayAppOrderResult.getSign());
        respPayWxJson.setTimestamp(wxPayAppOrderResult.getTimeStamp());
        respPayWxJson.setPartnerid(wxPayAppOrderResult.getPartnerId());
    }
}

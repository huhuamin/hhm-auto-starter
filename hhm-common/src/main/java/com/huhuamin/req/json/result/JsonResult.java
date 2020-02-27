package com.huhuamin.req.json.result;

/**
 * @Author 胡化敏
 * @Description: api 访问返回
 * @Date Create 2017/11/20 11:11
 * @Modified By:
 * @Since:
 */
public class JsonResult {

    /**
     * statusCode 成功 返回 true 失败返回false
     */
    private Boolean statusCode;
    /**
     * 内部错误码
     */
    private Integer code;
    /**
     * 错误描述
     */
    private String message;

    public JsonResult(Boolean statusCode) {
        this.statusCode = statusCode;
        if (statusCode) {
            this.code = 200;
        } else {
            this.code = 700;
        }

    }

    /**
     * 拦截器获取的额外信息，自己解析json ，但是用custId
     */
    private String extra;

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public JsonResult() {

    }

    /**
     * 分页信息
     */

    public Boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Boolean statusCode) {

        this.statusCode = statusCode;
        if (statusCode) {
            this.code = 200;
        } else {
            this.code = 700;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

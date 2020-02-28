package com.huhuamin.result;

/**
 * @Author 胡化敏
 * @Description: 单个实例对象
 * @Date Create 2017/11/27 15:06
 * @Modified By:
 * @Since:
 */
public class TypeJsonResult<T> extends JsonResult {

    private Object payJson;

    private String codeUrl;
    private String htmlStr;
    private String sign;
    private Integer identityType;

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    /**
     * 步数
     */
    private Integer walkCount;

    public Integer getWalkCount() {
        return walkCount;
    }

    public void setWalkCount(Integer walkCount) {
        this.walkCount = walkCount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 需要返回的实体
     */
    private T type;

    public TypeJsonResult() {
        this.setStatusCode(false);

    }

    public TypeJsonResult(T type) {
        super.setStatusCode(true);
        this.type = type;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getHtmlStr() {
        return htmlStr;
    }

    public void setHtmlStr(String htmlStr) {
        this.htmlStr = htmlStr;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public Object getPayJson() {
        return payJson;
    }

    public void setPayJson(Object payJson) {
        this.payJson = payJson;
    }
}

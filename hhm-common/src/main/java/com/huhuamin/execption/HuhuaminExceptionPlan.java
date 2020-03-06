package com.huhuamin.execption;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/22 19:36
 * @Modified By:
 * @Since:
 */
public class HuhuaminExceptionPlan extends RuntimeException {

    public HuhuaminExceptionPlan(String message, Exception e) {
        super(message, e);
        e.printStackTrace();
    }

    public HuhuaminExceptionPlan(String message) {

        super(message);
    }
}

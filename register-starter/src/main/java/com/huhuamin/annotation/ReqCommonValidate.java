package com.huhuamin.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 21:15
 * @Description: 公告标注
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface ReqCommonValidate {
}

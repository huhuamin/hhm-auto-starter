package com.huhuamin.mybatis.mapper;

import com.huhuamin.req.ReqComm;
import com.huhuamin.result.JsonResult;


/**
 * @param <Req> {@link ReqComm}
 * @param <R>   {@link JsonResult}
 * @Auther: Huhuamin
 * @Date: 2020/2/28 10:56
 * @Description: 自动装配业务逻辑层的生命周期
 */
public interface HhmPostProcessor<Req extends ReqComm, R extends JsonResult> {
    /**
     * 前置处理
     *
     * @param req 请求参数
     * @param r   避免频繁反射，外部传入  已经实例化的 JsonResult
     * @return
     */
    R postProcessorBefore(Req req, R r);

    /**
     * 后置处理
     *
     * @param req
     * @param r   避免频繁反射，外部传入  已经实例化的 JsonResult
     * @return
     */
    public R postProcessorAfter(Req req, R r);

}

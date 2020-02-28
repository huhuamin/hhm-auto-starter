package com.huhuamin.service;

import com.huhuamin.mybatis.mapper.MapperDb;
import com.huhuamin.req.ReqComm;
import com.huhuamin.req.json.result.JsonResult;

/**
 * 通用Mapper处理，自动注入提供默认实现，用户重新覆盖扩展
 *
 * @param <M>{@link MapperDb}
 */
public interface Service<M extends MapperDb, Req extends ReqComm> {

    <R extends JsonResult> R doService(M mapper, Req reqSource);

}

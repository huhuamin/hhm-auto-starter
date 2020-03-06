package com.huhuamin.service;

import com.huhuamin.mybatis.mapper.MapperDb;
import com.huhuamin.req.ReqComm;
import com.huhuamin.result.JsonResult;

import java.util.List;

/**
 * 通用Mapper处理，自动注入提供默认实现，用户重新覆盖扩展
 *
 * @param <M>{@link MapperDb}
 */
public interface Service<M extends MapperDb, Req extends ReqComm,T extends JsonResult> {
    /**
     * 单表业务逻辑处理
     *
     * @param mapper
     * @param reqSource
     * @param mapperExtra 额外的数据库操作由实现接口自己处理
     * @return
     */
    T doService(M mapper, Req reqSource, List<MapperDb> mapperExtra);

    /**
     * 单表业务逻辑处理
     *
     * @param mapper
     * @param reqSource
     * @return
     */
     T doService(M mapper, Req reqSource);


}

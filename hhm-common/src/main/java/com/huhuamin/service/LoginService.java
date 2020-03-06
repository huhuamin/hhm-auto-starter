package com.huhuamin.service;

import com.huhuamin.mybatis.mapper.MapperDb;
import com.huhuamin.req.ReqComm;
import com.huhuamin.result.JsonResult;
import com.huhuamin.result.TypeJsonResult;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/5 00:37
 * @Description:
 */
public interface LoginService<M extends MapperDb, Req extends ReqComm> {
    
    /**
     * 登录
     *
     * @param mapper
     * @param reqSource
     * @return
     */
    TypeJsonResult doLogin(M mapper, Req reqSource);

    /**
     * 登出
     *
     * @param mapper
     * @param reqSource
     * @return
     */
    JsonResult doLogout(M mapper, Req reqSource);

    /**
     * 注销
     *
     * @param mapper
     * @param reqSource
     * @return
     */
    JsonResult doDie(M mapper, Req reqSource);
}

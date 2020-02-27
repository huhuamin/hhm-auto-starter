package com.huhuamin.starter.register.service;

import com.huhuamin.mybatis.Mapper;

/**
 * 注册接口
 */
public interface RegisterService<M extends Mapper, OTHER extends Mapper> {
    /**
     * 注册主表业务逻辑
     *
     * @param m
     * @return
     */
    boolean register(M m);

    /**
     * 辅助业务逻辑
     *
     * @param other
     * @return
     */
    boolean registerHook(M other);


}

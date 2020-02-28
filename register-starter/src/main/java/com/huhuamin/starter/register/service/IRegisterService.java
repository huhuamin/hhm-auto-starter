package com.huhuamin.starter.register.service;

import com.huhuamin.service.Service;
import com.huhuamin.starter.register.dao.mapper.CustomerMapper;
import com.huhuamin.starter.register.req.ReqLoginPhone;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 18:30
 * @Description:
 */
public interface IRegisterService extends Service<CustomerMapper, ReqLoginPhone> {
}

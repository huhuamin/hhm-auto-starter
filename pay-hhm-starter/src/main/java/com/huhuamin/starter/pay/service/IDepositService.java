package com.huhuamin.starter.pay.service;

import com.huhuamin.result.TypeJsonResult;
import com.huhuamin.service.Service;
import com.huhuamin.starter.pay.dao.mapper.DepoistMapper;
import com.huhuamin.starter.pay.req.ReqPayDeposit;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/6 23:41
 * @Description:
 */
public interface IDepositService extends Service<DepoistMapper, ReqPayDeposit, TypeJsonResult> {

}

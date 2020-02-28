package com.huhuamin.starter.register.dao.mapper;

import com.huhuamin.starter.register.dao.model.SystemParam;

public interface SystemParamMapper {
    /**
     * andji_system_param_base 根据主键删除 
     *
     * @mbg.generated Sat Feb 29 00:04:30 CST 2020
     */
    int deleteByPrimaryKey(String paramId);

    /**
     * andji_system_param_base  动态插入 
     *
     * @mbg.generated Sat Feb 29 00:04:30 CST 2020
     */
    int insertSelective(SystemParam record);

    /**
     * andji_system_param_base  动态查询 
     *
     * @mbg.generated Sat Feb 29 00:04:30 CST 2020
     */
    int selectSelective(SystemParam record);

    /**
     * andji_system_param_base 根据主键查询 
     *
     * @mbg.generated Sat Feb 29 00:04:30 CST 2020
     */
    SystemParam selectByPrimaryKey(String paramId);

    /**
     * andji_system_param_base  根据主键动态修改 
     *
     * @mbg.generated Sat Feb 29 00:04:30 CST 2020
     */
    int updateByPrimaryKeySelective(SystemParam record);
}
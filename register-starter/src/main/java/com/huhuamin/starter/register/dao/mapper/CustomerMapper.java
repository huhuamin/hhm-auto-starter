package com.huhuamin.starter.register.dao.mapper;

import com.huhuamin.mybatis.mapper.MapperDb;
import com.huhuamin.starter.register.dao.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper extends MapperDb<Customer> {
    /**
     * clzah_basic_customer_base 根据主键删除
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    int deleteByPrimaryKey(String custId);

    /**
     * clzah_basic_customer_base  动态插入
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    int insertSelective(Customer record);

    /**
     * clzah_basic_customer_base  动态查询
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    List<Customer> selectSelective(Customer record);

    /**
     * clzah_basic_customer_base 根据主键查询
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    Customer selectByPrimaryKey(String custId);

    /**
     * clzah_basic_customer_base  根据主键动态修改
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    int updateByPrimaryKeySelective(Customer record);

    String selectDefaultImg(@Param("paramIndex") String paramIndex);
}
package com.huhuamin.mybatis.mapper;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 10:56
 * @Description: 数据库层抽象接口
 */
public interface MapperDb<T> {
    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 选择性插入
     *
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 选择性查找
     *
     * @param record
     * @return
     */
    List<T> selectSelective(T record);

    /**
     * 根据主键查找
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(String id);

    /**
     * 根据主键选择性更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);
}

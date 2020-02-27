package com.huhuamin.mybatis;

import java.util.List;

public interface Mapper<T> {

    int deleteByPrimaryKey(String id);

    List<T> insertSelective(T record);

    T selectSelective(T record);

    T selectByPrimaryKey(String id);

}

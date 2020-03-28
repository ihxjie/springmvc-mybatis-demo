package com.ex.dao;

import com.ex.model.Reason;

public interface ReasonMapper {
    int deleteByPrimaryKey(Integer projectid);

    int insert(Reason record);

    int insertSelective(Reason record);

    Reason selectByPrimaryKey(Integer projectid);

    int updateByPrimaryKeySelective(Reason record);

    int updateByPrimaryKey(Reason record);
}
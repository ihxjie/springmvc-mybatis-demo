package com.ex.dao;

import com.ex.model.Reason;

public interface ReasonMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Reason record);//插入审核不通过理由

    int insertSelective(Reason record);

    Reason selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Reason record);

    int updateByPrimaryKey(Reason record);
}
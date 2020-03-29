package com.ex.dao;

import com.ex.model.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer stuffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer stuffId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}
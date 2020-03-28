package com.ex.dao;

import com.ex.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Admin record);//修改管理员信息

    int updateByPrimaryKey(Admin record);

    Admin getLoginAdmin(String adminId);//登录

    Admin getAdminById(String adminId);//
}
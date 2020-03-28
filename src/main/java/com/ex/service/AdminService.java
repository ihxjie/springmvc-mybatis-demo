package com.ex.service;

import com.ex.model.Admin;
import com.ex.model.Student;

public interface AdminService {
    public Admin login(String adminId, String adminPwd)throws Exception;//登录

    Admin getAdminById(String adminId);//获取id

    boolean updateByPrimaryKey(Admin admin);//修改

}

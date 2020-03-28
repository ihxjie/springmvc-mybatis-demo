package com.ex.service.impl;

import com.ex.dao.AdminMapper;
import com.ex.dao.StudentMapper;
import com.ex.model.Admin;
import com.ex.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin login(String adminId, String adminPwd) throws Exception {
        Admin admin=null;
        admin=adminMapper.getLoginAdmin(adminId);
        if(null!=admin)
        {
            if(!admin.getAdminPwd().equals(adminPwd))
                admin=null;
        }
        return admin;
    }

    @Override
    public Admin getAdminById(String adminId) {
        return adminMapper.getAdminById(adminId);
    }

    @Override
    public boolean updateByPrimaryKey(Admin admin) {
        boolean flag = false;
        int x;
        x=adminMapper.updateByPrimaryKey(admin);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

}

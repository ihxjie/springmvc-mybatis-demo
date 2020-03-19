package com.ex.service.impl;

import com.ex.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin findAdminByUsername(String username) {
        return adminMapper.selectByPrimaryKey(username);
    }
}

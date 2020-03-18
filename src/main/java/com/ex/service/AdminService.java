package com.ex.service;

import com.ex.model.Admin;

public interface AdminService {
    Admin findAdminByUsername(String username);
}

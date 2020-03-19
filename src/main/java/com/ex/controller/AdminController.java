package com.ex.controller;

import com.ex.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;


    @GetMapping("/login")
    public String login(){
        return "adminLogin";
    }

    @PostMapping("/validate")
    public String validate(@ModelAttribute Admin admin, Model model, HttpSession session){
        Admin a = adminService.findAdminByUsername(admin.getUsername());
        if (a.getPassword().equals(admin.getPassword())){
            session.setAttribute("username",a.getUsername());
            return "adminProductBackstageSys";
        }
        model.addAttribute("info","账号或密码错误");
        return "adminLogin";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "adminLogin";
    }
    @GetMapping("/ProductBackstageSys")
    public String backstageSys(){
        return "adminProductBackstageSys";
    }
    @GetMapping("/TypeBackstageSys")
    public String typeBackSys(){
        return "adminTypeBackstageSys";
    }
    @GetMapping("/UserBackstageSys")
    public String userBackSys(){
        return "adminUserBackstageSys";
    }
    @GetMapping("/OrderDetailBackstageSys")
    public String orderDetailBackSys(){
        return "adminOrderDetailBackstageSys";
    }
    @GetMapping("/BorderBackstageSys")
    public String borderBackSys(){
        return "adminBorderBackstageSys";
    }
    @GetMapping("/OrderBasisBackstageSys")
    public String orderBasisBackSys(){
        return "adminOrderBasisBackstageSys";
    }
}

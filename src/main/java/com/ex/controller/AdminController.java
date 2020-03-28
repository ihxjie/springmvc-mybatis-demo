package com.ex.controller;

import com.ex.model.Admin;
import com.ex.model.Student;
import com.ex.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;
    private Logger logger = Logger.getLogger(AdminController.class);

    @RequestMapping(value="/sys/adminList/modify/{adminId}",method=RequestMethod.GET)
    public String getStudentModify(@PathVariable String adminId,Model model,HttpServletRequest request){
        logger.debug("getProviderById typeId===================== "+adminId);
        Admin admin = new Admin();
        try {
            admin = adminService.getAdminById(adminId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getProviderById studentId===================== "+admin .getAdminId());
        model.addAttribute(admin );
        return "updateadmin";
    }
    @RequestMapping(value="/sys/adminList/modifysave.html",method=RequestMethod.POST)
    public String modifyAdminSave(Admin admin){
        logger.debug("modifyAdminSave id===================== "+admin.getAdminId());
        try {
            if(adminService.updateByPrimaryKey(admin)){
                return "redirect:/adminindex.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updateadmin";
    }
}

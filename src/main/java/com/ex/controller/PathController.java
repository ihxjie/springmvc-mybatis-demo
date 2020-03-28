package com.ex.controller;

import com.ex.dao.*;
import com.ex.model.Company;
import com.ex.model.Project;
import com.ex.model.StudentTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PathController {

    @Resource
    AdminMapper adminMapper;
    @Resource
    StudentMapper studentMapper;
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    CompanyMapper companyMapper;
    @Resource
    ProjectMapper projectMapper;


    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @GetMapping("/enroll")
    public String enroll(){
        return "enroll";
    }
    @GetMapping("/student")
    public String student(){
        return "student";
    }
    @GetMapping("enrolment")
    public String enrolment(){
        return "enrolment";
    }
    @GetMapping("/company")
    public String company(HttpSession session, Model model){
        Company company = companyMapper.selectByPrimaryKey(session.getAttribute("username").toString());
        model.addAttribute("company", company);
        return "company";
    }
    @GetMapping("/new_project")
    public String new_project(HttpSession session, Model model){
        String username = session.getAttribute("username").toString();
        List<Project> passedList = projectMapper.selectPassedProject(username);
        List<Project> rejectedList = projectMapper.selectRejectedProject(username);
        List<Project> applyingList = projectMapper.selectApplyingProject(username);

        model.addAttribute("applyingList", applyingList);
        model.addAttribute("passedList", passedList);
        model.addAttribute("rejectedList", rejectedList);

        return "new_project";
    }

}

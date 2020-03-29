package com.ex.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ex.dao.*;
import com.ex.model.Company;
import com.ex.model.Project;
import com.ex.model.Student;
import com.ex.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    AdminMapper adminMapper;
    @Resource
    StudentMapper studentMapper;
    @Resource
    CompanyMapper companyMapper;
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    ProjectMapper projectMapper;

    @PostMapping("/stu_validate")
    public String stu_validate(String username, String password, Model model, HttpSession session){

        Student s =  studentMapper.selectByPrimaryKey(username);

        if(s != null && s.getStudentPwd().equals(password)){
            session.setAttribute("username", username);
            session.setAttribute("userEmail", s.getStudentEmail());
            session.setAttribute("userTel", s.getStudentTel());
            session.setAttribute("userSex", s.getStudentSex());
            session.setAttribute("userMajor", s.getStudentMajor());
            session.setAttribute("userClass", s.getStudentClass());
            session.setAttribute("name", s.getStudentName());
            return "student";
        }
        model.addAttribute("info", "failed");
        return "login";
    }

    @PostMapping(value = "/company_validate", produces = "text/plain;charset=utf-8")
    public String company_validate(String username, String password, Model model, HttpSession session){

        Company c =  companyMapper.selectByPrimaryKey(username);
        List<Project> passedList = projectMapper.selectPassedProject(username);
        List<Project> rejectedList = projectMapper.selectRejectedProject(username);
        List<Project> applyingList = projectMapper.selectApplyingProject(username);

        if(c != null && c.getCompanyPwd().equals(password)){
            session.setAttribute("username", username);
            model.addAttribute("company", c);

            model.addAttribute("applyingList", applyingList);
            model.addAttribute("passedList", passedList);
            model.addAttribute("rejectedList", rejectedList);

            return "company";
        }
        model.addAttribute("info", "failed");
        return "login";
    }

    @PostMapping("/private_information_modify")
    public String private_information_modify(@ModelAttribute Student student, HttpSession session){
        student.setStudentId(session.getAttribute("username").toString());
        studentMapper.updateByPrimaryKeySelective(student);
        return "redirect:student";
    }
    @PostMapping("/company_information_modify")
    public String company_information_modify(@ModelAttribute Company company, HttpSession session){
        company.setCompanyId(session.getAttribute("username").toString());
        companyMapper.updateByPrimaryKeySelective(company);
        return "redirect:/company";
    }

    @GetMapping(value = "/getStudentInfo" ,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getStudentInfo(HttpSession session){
        String username = session.getAttribute("username").toString();
        Student student = studentMapper.selectByPrimaryKey(username);
        return JSONObject.toJSONString(student, SerializerFeature.WriteMapNullValue);
    }

}

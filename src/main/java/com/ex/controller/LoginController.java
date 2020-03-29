package com.ex.controller;

import com.ex.dao.TeacherMapper;
import com.ex.model.Admin;
import com.ex.model.Teacher;
import com.ex.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private Logger logger = Logger.getLogger(LoginController.class);

    @Resource
    private TeacherService teacherService;

    @Resource
    TeacherMapper teacherMapper;

    @GetMapping(value="/login")
    public String login() {
        return "login";
    }

    @GetMapping("teacherindex")
    public String teacherindex(){
        return "teacherindex";
    }

    @PostMapping("/teacher_validate")
    public String stu_validate(String username, String password, Model model, HttpSession session){
        System.out.println(username);

        Teacher t =  teacherMapper.selectByPrimaryKey(username);
        System.out.println(t);

        if(t != null && t.getTeacherPwd().equals(password)){
            session.setAttribute("teacherId", t.getTeacherId());
            session.setAttribute("teacherName", t.getTeacherName());
            session.setAttribute("teacherSex", t.getTeacherSex());
            session.setAttribute("teacherTel", t.getTeacherTel());
            session.setAttribute("teacherEmail", t.getTeacherEmail());
            session.setAttribute("introduction", t.getIntroduction());
            return "teacherindex";
        }

        model.addAttribute("info", "failed");
        return "login";
    }

    @RequestMapping(value="/dologin.html",method=RequestMethod.POST)
    public String doLogin(@RequestParam String teacherId, @RequestParam String teacherPwd, HttpServletRequest request, HttpSession session) throws Exception{
        logger.debug("doLogin====================================");
        Teacher teacher = teacherService.login(teacherId, teacherPwd);
        if( teacher!= null &&  teacher.getTeacherPwd().equals(teacherPwd)){
            session.setAttribute("teacherId", teacher.getTeacherId());
            session.setAttribute("teacherName", teacher.getTeacherName());
            return "redirect:/sys/main.html";
        }
        return "login";
    }
    @RequestMapping(value="/sys/main.html")
    public String main(){
        return "teacherindex";
    }


}

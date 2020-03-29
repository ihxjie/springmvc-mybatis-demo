package com.ex.controller;

import com.ex.dao.AdminMapper;
import com.ex.dao.TeacherMapper;
import com.ex.model.Admin;
import com.ex.model.Student;
import com.ex.model.Teacher;
import com.ex.service.AdminService;
import com.ex.service.StudentService;
import com.ex.service.TeacherService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Resource
    private AdminService adminService;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    TeacherMapper teacherMapper;

    private Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value="/login.html")
    public String login_html() {
        logger.debug("Maser welcome Business==================");
        return "login";
    }
    @RequestMapping(value="/dologin.html",method=RequestMethod.POST)
    public String doLogin(@RequestParam String adminId, @RequestParam String adminPwd, HttpServletRequest request, HttpSession session) throws Exception{
        logger.debug("doLogin====================================");
        Admin admin = adminService.login(adminId, adminPwd);
        if( admin!= null &&  admin.getAdminPwd().equals(adminPwd)){
            session.setAttribute("adminId", adminId);
            session.setAttribute("adminId", admin.getAdminId());
            return "redirect:/main.html";
        }else{
            request.setAttribute("error", "znmjshshhs");
            return "login";
        }
    }
    @RequestMapping(value="/main.html")
    public String main(){
        return "adminindex";
    }
    @RequestMapping(value="/logout.html")
    public String logout(HttpSession session){
        session.removeAttribute(String.valueOf(session));
        return "login";
    }
    @RequestMapping("/sys/studentList/regist.html")
    public String regist(){
        return "regist";
    }

    @RequestMapping("/admin/doRegist")
    public String doRegist(Student student, Model model){
        System.out.println(student.getStudentId());
        studentService.insert(student);
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

    @RequestMapping(value="/sys/main.html")
    public String teacher_main(){
        return "teacherindex";
    }
}

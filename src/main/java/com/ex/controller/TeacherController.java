package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Project;
import com.ex.model.Teacher;
import com.ex.service.TeacherService;
import com.ex.tools.Constants;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
@RequestMapping("/sys/teacherlist")
public class TeacherController {
    private Logger logger = Logger.getLogger(TeacherController.class);

    @Resource
    private TeacherService teacherService;


    @GetMapping("teacherindex")
    public String teacherindex(){
        return "teacherindex";
    }

    @RequestMapping(value="/view.html",method=RequestMethod.GET)
    public String view(Teacher teacher,HttpServletRequest request,HttpSession session){
       request.setAttribute("teacherId",teacher.getTeacherId());
       request.setAttribute("teacherName",teacher.getTeacherName());
       request.setAttribute("teacherSex",teacher.getTeacherSex());
       request.setAttribute("teacherEmail",teacher.getTeacherEmail());
       request.setAttribute("teacherTel",teacher.getTeacherTel());
       request.setAttribute("introduction",teacher.getIntroduction());

        logger.debug("view tid===================== ");
        try {
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "teacherview";
    }


    //信息修改
    @RequestMapping(value="modify.html",method=RequestMethod.GET)
    public String getTeacherModify(Teacher teacher,Model model,HttpServletRequest request){
        request.setAttribute("teacherId",teacher.getTeacherId());
        request.setAttribute("teacherName",teacher.getTeacherName());
        request.setAttribute("teacherSex",teacher.getTeacherSex());
        request.setAttribute("teacherEmail",teacher.getTeacherEmail());
        request.setAttribute("teacherTel",teacher.getTeacherTel());
        request.setAttribute("introduction",teacher.getIntroduction());

        try {
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getProviderById studentId===================== "+teacher .getTeacherId());
        model.addAttribute(teacher);
        return "teachermodify";
    }

    @RequestMapping(value="modifysave.html",method=RequestMethod.POST)
    public String modifyTeacherSave(Teacher teacher,Model model,HttpServletRequest request){
        request.setAttribute("teacherId",teacher.getTeacherId());
        request.setAttribute("teacherName",teacher.getTeacherName());
        request.setAttribute("teacherSex",teacher.getTeacherSex());
        request.setAttribute("teacherEmail",teacher.getTeacherEmail());
        request.setAttribute("teacherTel",teacher.getTeacherTel());
        request.setAttribute("introduction",teacher.getIntroduction());
        logger.debug("modifyGoodsSave id===================== "+teacher.getTeacherName());
        try {
            if(teacherService.updateByPrimaryKey(teacher)){
                return "redirect:/teacherindex.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "teachermodify";
    }


    //修改密码
    @RequestMapping(value="/updatepwd.json",method=RequestMethod.POST)
    @ResponseBody
    public Object getPwdByTeacherId(@RequestParam String oldteacherPwd, HttpSession session,HttpServletRequest request){
        logger.debug("qqqqqqqqqqqqqqqq");
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(null == session.getAttribute(Constants.Teacher_SESSION) ){//session过期
            resultMap.put("result", "sessionerror");
        }else if(StringUtils.isEmpty(oldteacherPwd)){//旧密码输入为空
            resultMap.put("result", "error");
        }else{
            String sessionPwd = ((Teacher)session.getAttribute(Constants.Teacher_SESSION)).getTeacherPwd();
            if(oldteacherPwd.equals(sessionPwd)){
                resultMap.put("result", "true");
            }else{//旧密码输入不正确
                resultMap.put("result", "false");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }
    //保存新密码
    @RequestMapping(value="/pwdsave.html")
    public String pwdSave(@RequestParam(value="newteacherPwd") String newteacherPwd,
                          HttpSession session,
                          HttpServletRequest request){
        boolean flag = false;
        Object o = session.getAttribute(Constants.Teacher_SESSION);
        if(o != null && !StringUtils.isEmpty(newteacherPwd)){
            try {
                flag = teacherService.updatePwd(((Teacher)o).getTeacherId(),newteacherPwd);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(flag){
                request.setAttribute(Constants.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
                session.removeAttribute(Constants.Teacher_SESSION);//session注销
                return "login";
            }else{
                request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
            }
        }else{
            request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
        }
        return "redirect:/sys/main.html";
    }

    @RequestMapping(value="/updatepwd.html",method=RequestMethod.GET)
    public String updatepwd(Model model,HttpSession session){
        logger.debug("aaaaaaaaaaaaaaaaaaaa");
        return "updatepwd";
    }


}

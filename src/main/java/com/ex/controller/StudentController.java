package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Student;
import com.ex.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;
    private Logger logger = Logger.getLogger(StudentController.class);

    @RequestMapping(value = "/studentlist", method = RequestMethod.GET)
    public String getStudentlist(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Student> studentList  = studentService.getStudentList();
        //使用PageInfo包装数据
        PageInfo<Student> pageInfo=new PageInfo<Student>(studentList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("studentList",studentList);
        return "studentlist";
    }

    @RequestMapping(value="/sys/studentlist/view/{studentId}",method=RequestMethod.GET)
    public String view(@PathVariable String studentId, Model model, HttpServletRequest request){
        logger.debug("view id===================== "+studentId);
        Student student = new Student();
        try {
            student =studentService.getStudentById(studentId);
            logger.debug("wwwwwwwwwwww ");
            logger.debug("view Pno===================== "+student.getStudentId());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(student);
        return "studentview";
    }
    @RequestMapping(value="/delStudent",method=RequestMethod.POST)
    @ResponseBody
    public Object delStudent(@RequestParam(value="studentId" ,required=true) String studentId)
    {
        boolean flag = true;
        if(!studentService.deleteByPrimaryKey(studentId))
        {
            flag = false;
        }
        return JSONArray.toJSONString(flag);
    }
    @RequestMapping(value="/sys/studentList/modify/{studentId}",method=RequestMethod.GET)
    public String getStudentModify(@PathVariable String studentId,Model model,HttpServletRequest request){
        logger.debug("getProviderById typeId===================== "+studentId);
        Student student = new Student();
        try {
            student = studentService.getStudentById(studentId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getProviderById studentId===================== "+student .getStudentId());
        model.addAttribute(student );
        return "updatestudent";
    }
    @RequestMapping(value="/sys/studentList/modifysave.html",method=RequestMethod.POST)
    public String modifyStudentSave(Student student){
        logger.debug("modifyGoodsSave id===================== "+student.getStudentName());
        try {
            if(studentService.updateByPrimaryKey(student)){
                return "redirect:/studentList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updatestudent";
    }
    @RequestMapping(value="/sys/courselist/list.html")
    public String Searchview(@PathVariable String studentId, Model model, HttpServletRequest request){
        logger.debug("view id===================== "+studentId);
        Student student = new Student();
        try {
            student =studentService.selectByPrimaryKey(studentId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(student);
        return "studentview";
    }
}

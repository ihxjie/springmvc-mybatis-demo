package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Student;
import com.ex.model.Teacher;
import com.ex.service.AdminService;
import com.ex.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    private Logger logger = Logger.getLogger(TeacherController.class);
    @RequestMapping(value = "/teacherList", method = RequestMethod.GET)
    public String getTeacherList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Teacher> teacherList  = teacherService.getTeacherList();
        //使用PageInfo包装数据
        PageInfo<Teacher> pageInfo=new PageInfo<Teacher>(teacherList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("teacherList",teacherList);
        return "teacherList";
    }
    @RequestMapping(value="/sys/teacherList/view/{teacherId}",method=RequestMethod.GET)
    public String view(@PathVariable String teacherId, Model model, HttpServletRequest request){
        logger.debug("view id===================== "+teacherId);
        Teacher teacher = new Teacher();
        try {
            teacher=teacherService.getTeacherById(teacherId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(teacher);
        return "teacherview";
    }
    @RequestMapping(value="sys/teacherList/looklist.html",method=RequestMethod.POST)
    public String viewstudent(Model model,
                              @RequestParam(value="teacherId",required=false) String teacherId,
                              @RequestParam(value="page",required=false) String page) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        //紧跟的第一个select方法被分页
        List<Teacher> teacherList = teacherService.selectId(teacherId);
        //使用PageInfo包装数据
        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(teacherList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("teacherList", teacherList);
        return "teacherList";
    }
    @RequestMapping("/sys/teacherList/add.html")
    public String addTeacher() {
        return "addTeacher";
    }
    @RequestMapping(value="/sys/teacherList/addTeacher.html",method=RequestMethod.POST)
    public String addTeacherSave(Teacher teacher, HttpSession session, HttpServletRequest request){
        System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+teacher.getTeacherId());
        try {
            if(teacherService.insert(teacher)){
                return "redirect:/teacherList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "404";
    }
    @RequestMapping(value="/delTeacher",method=RequestMethod.POST)
    @ResponseBody
    public Object delTeacher(@RequestParam(value="teacherId" ,required=true) String teacherId)
    {
        boolean flag = true;
        if(!teacherService.deleteTeacher(teacherId))
        {
            flag = false;
        }
        return JSONArray.toJSONString(flag);
    }
    @RequestMapping(value="/delTeachers",method=RequestMethod.POST)
    @ResponseBody
    public Object delGoods(@RequestParam(value="list" ,required=false) List<String>list) throws Exception
    {
        boolean flag = true;
        for(String id : list) {
            if(!teacherService.delTeacherById(id))
            {
                flag = false;
            }
        }
        return JSONArray.toJSONString(flag);
    }

    @RequestMapping(value="/sys/teacherList/modify/{teacherId}",method=RequestMethod.GET)
    public String getTeacherModify(@PathVariable String teacherId,Model model,HttpServletRequest request){
        logger.debug("getProviderById typeId===================== "+teacherId);
        Teacher teacher = new Teacher();
        try {
            teacher= teacherService.getTeacherById(teacherId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getProviderById studentId===================== "+teacher .getTeacherId());
        model.addAttribute(teacher);
        return "updateteacher";
    }
    @RequestMapping(value="/sys/teacherList/modifysave.html",method=RequestMethod.POST)
    public String modifyTeacherSave(Teacher teacher){
        logger.debug("modifyGoodsSave id===================== "+teacher.getTeacherName());
        try {
            if(teacherService.updateByPrimaryKey(teacher)){
                return "redirect:/teacherList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updateteacher";
    }
    @RequestMapping("/sys/teacherController/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Teacher> list =teacherService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("教师表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("教师id");
        titleRow.createCell(1).setCellValue("教师姓名");
        titleRow.createCell(2).setCellValue("教师性别");
        titleRow.createCell(3).setCellValue("教师电话");
        titleRow.createCell(4).setCellValue("简介");
        titleRow.createCell(5).setCellValue("教师邮箱");

        //遍历将数据放到excel列中
        for (Teacher teacher : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(teacher.getTeacherId());
            dataRow.createCell(1).setCellValue(teacher.getTeacherName());
            dataRow.createCell(2).setCellValue(teacher.getTeacherSex());
            dataRow.createCell(3).setCellValue(teacher.getTeacherTel());
            dataRow.createCell(4).setCellValue(teacher.getIntroduction());
            dataRow.createCell(5).setCellValue(teacher.getTeacherEmail());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("教师名单".getBytes(),"iso-8859-1") + ".xls");


        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();


    }
}

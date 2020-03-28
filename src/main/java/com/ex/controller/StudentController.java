package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Student;
import com.ex.service.StudentService;
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
import java.util.HashMap;
import java.util.List;
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;
    private Logger logger = Logger.getLogger(StudentController.class);

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public String getStudentList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Student> studentList = studentService.getStudentList();
        //使用PageInfo包装数据
        PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("studentList", studentList);
        return "studentList";
    }

    @RequestMapping(value = "/sys/studentList/view/{studentId}", method = RequestMethod.GET)
    public String view(@PathVariable String studentId, Model model, HttpServletRequest request) {
        logger.debug("view id===================== " + studentId);
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
        model.addAttribute(student);
        return "studentview";
    }

    @RequestMapping(value="/sys/studentList/looklist.html",method=RequestMethod.POST)
    public String viewstudent(Model model,
                              @RequestParam(value="studentId",required=false) String studentId,
    @RequestParam(value="page",required=false) String page) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        //紧跟的第一个select方法被分页
        List<Student> studentList = studentService.selectId(studentId);
        //使用PageInfo包装数据
        PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("studentList", studentList);
        return "studentList";
    }
    @RequestMapping("/sys/studentList/add.html")
    public String addStudent() {

        return "addStudent";
    }

    @RequestMapping(value="/sys/studentList/addStudent.html",method=RequestMethod.POST)
    public String addStudentSave(Student student, HttpSession session, HttpServletRequest request){
        System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+student.getStudentId());
        try {
            if(studentService.insert(student)){
                return "redirect:/studentList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "studentList";
    }

    @RequestMapping(value = "/delStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object delStudent(@RequestParam(value = "studentId", required = true) String studentId) {
        boolean flag = true;
        if (!studentService.deleteStudent(studentId)) {
            flag = false;
        }
        return JSONArray.toJSONString(flag);
    }
    @RequestMapping(value="/delStudents",method=RequestMethod.POST)
    @ResponseBody
    public Object delGoods(@RequestParam(value="list" ,required=false) List<String>list) throws Exception
    {
        boolean flag = true;
        for(String id : list) {
            if(!studentService.delStudentById(id))
            {
                flag = false;
            }
        }
        return JSONArray.toJSONString(flag);
    }


    @RequestMapping(value = "/sys/studentList/modify/{studentId}", method = RequestMethod.GET)
    public String getStudentModify(@PathVariable String studentId, Model model, HttpServletRequest request) {
        logger.debug("getProviderById typeId===================== " + studentId);
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
        logger.debug("getProviderById studentId===================== " + student.getStudentId());
        model.addAttribute(student);
        return "updatestudent";
    }

    @RequestMapping(value = "/sys/studentList/modifysave.html", method = RequestMethod.POST)
    public String modifyStudentSave(Student student) {
        logger.debug("modifyGoodsSave id===================== " + student.getStudentName());
        try {
            if (studentService.updateByPrimaryKey(student)) {
                return "redirect:/studentList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updatestudent";
    }

    @RequestMapping(value = "/sys/courselist/list.html")
    public String Searchview(@PathVariable String studentId, Model model, HttpServletRequest request) {
        logger.debug("view id===================== " + studentId);
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
        model.addAttribute(student);
        return "studentview";
    }

    @RequestMapping("/sys/customerMassWebController/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Student> list =studentService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("学生表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("学生账号");
        titleRow.createCell(1).setCellValue("学生姓名");
        titleRow.createCell(2).setCellValue("学生性别");
        titleRow.createCell(3).setCellValue("专业");
        titleRow.createCell(4).setCellValue("班级");
        titleRow.createCell(5).setCellValue("联系电话");
        titleRow.createCell(6).setCellValue("邮箱");

        //遍历将数据放到excel列中
        for (Student student : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(student.getStudentId());
            dataRow.createCell(1).setCellValue(student.getStudentName());
            dataRow.createCell(2).setCellValue(student.getStudentSex());
            dataRow.createCell(3).setCellValue(student.getStudentMajor());
            dataRow.createCell(4).setCellValue(student.getStudentClass());
            dataRow.createCell(5).setCellValue(student.getStudentTel());
            dataRow.createCell(6).setCellValue(student.getStudentEmail());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("学生名单".getBytes(),"iso-8859-1") + ".xls");


        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();


    }

    @RequestMapping(value="/sys/studentList/csexist.json")
    @ResponseBody
    public Object GoodsIsExit(@RequestParam String studentId){
        logger.debug("cnameIsExit studentId===================== "+studentId);
        HashMap<String, String> resultMap = new HashMap<String, String>();
           Student student= null;
            try {

                student =  studentService.selectStudentExist(studentId);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(null != student)
                resultMap.put("studentId", "exist");
            else
                resultMap.put("studentId", "noexist");
        return JSONArray.toJSONString(resultMap);
        }
    @RequestMapping(value="/sys/studentList/csexistEmail.json")
    @ResponseBody
    public Object Exit(@RequestParam String studentEmail){
        logger.debug("cnameIsExit studentEmail===================== "+studentEmail);
        HashMap<String, String> resultMap = new HashMap<String, String>();
        Student student= null;
        try {

            student =  studentService.selectEmailExist(studentEmail);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(null != student)
            resultMap.put("studentEmail", "exist");
        else
            resultMap.put("studentEmail", "noexist");
        return JSONArray.toJSONString(resultMap);
    }

}

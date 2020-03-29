package com.ex.controller;

import com.ex.model.Apply;
import com.ex.model.Project;
import com.ex.model.Result;
import com.ex.service.ApplyService;
import com.ex.service.ProjectService;
import com.ex.service.ResultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class ResultController {
    private Logger logger = Logger.getLogger(ResultController.class);

    @Resource
    private ResultService resultService;

    @Resource
    private ApplyService applyService;

    @Resource
    private ProjectService projectService;

    @RequestMapping(value="/sys/resultlist/list/{projectId}")
    public String getResultListProjectId(Model model, @PathVariable String projectId,@RequestParam(value = "page", defaultValue = "1")Integer page) {
        System.out.println("000000aaaaaaaaaaaa0000"+projectId);
        PageHelper.startPage(page, 8);
        List<Result> resultList = null;
        resultList=resultService.getResultByProjectId(Integer.valueOf(projectId));
        PageInfo<Result> pageInfo = new PageInfo<Result>(resultList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("resultList", resultList);
        model.addAttribute("resultProjectId", projectId);
        return "resultlist";
    }

    @RequestMapping(value="/sys/resultlist/view/{resultId}",method=RequestMethod.GET)
    public String view(@PathVariable String resultId,Model model,HttpServletRequest request,@RequestParam(value = "page", defaultValue = "1")Integer page){
        logger.debug("view id===================== "+resultId);
        PageHelper.startPage(page, 8);
        List<Result> resultList = null;
        Result  result = new Result();
        result =resultService.getResultById(Integer.parseInt(resultId));
        PageInfo<Result> pageInfo = new PageInfo<Result>(resultList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("resultList", resultList);
        return "resultview";
    }
    @RequestMapping(value="/sys/resultlist/liststudent/{projectId}")
    public String getGradeListstudent(Model model,  @PathVariable String projectId,@RequestParam(value = "page", defaultValue = "1")Integer page){
        logger.info("getUserList ---- > goodsName: " + projectId);
        PageHelper.startPage(page, 8);
        List<Apply> applyList = null;
        applyList = applyService.getApplyListStudent(Integer.parseInt(projectId));
        PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("applyList", applyList);
        model.addAttribute("resultId", projectId);
        return "resultstudent";
    }

    @RequestMapping(value="/sys/resultlist/pass.html")
    public String getProgramList(Model model, String projectTitle, @RequestParam(value = "page", defaultValue = "1")Integer page) {
        logger.info("getProgramList ---- > Pname: " + projectTitle);
        PageHelper.startPage(page, 8);
        List<Project> projectList = null;
        projectList=projectService.getProjectLiist(projectTitle);
        PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
        model.addAttribute("projectList", projectList);
        model.addAttribute("pageInfo", pageInfo);
        return "projectresult";
    }

    @RequestMapping(value="/sys/resultlist/add/{personId}",method=RequestMethod.GET)
    public String addGrade(Model model,@PathVariable String personId, Apply apply) {

        apply = applyService.getApplyById(personId);
        System.out.println("999999999999999999999999999999999"+apply.getProjectId());
        model.addAttribute("projectId",apply.getProjectId());
        model.addAttribute("studentId",apply.getPersonId());
        model.addAttribute("studentName",apply.getPersonName());
        model.addAttribute("applyId",apply.getApplyId());
        model.addAttribute("status",apply.getStatus());
        model.addAttribute("is_student",apply.getIsStudent());
        return "resultadd";
    }

    @RequestMapping(value="/sys/resultlist/addsave.html",method=RequestMethod.POST)
    public String addGradeSave(Model model, Result result, @RequestParam String projectId, HttpSession session, HttpServletRequest request) throws Exception{
        result.setProjectId(Integer.parseInt(projectId));
        try {
            if(resultService.insert(result)){
                System.out.println("bbbbbbbbbbbbbb"+result.getResult());
                return "redirect:/sys/resultlist/list/"+projectId;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "resultlist";
    }

    @RequestMapping("/sys/resultControllerrr/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Result> list =resultService.queryExcelInfooo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("学生成绩");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);

        titleRow.createCell(0).setCellValue("成绩编号");
        titleRow.createCell(1).setCellValue("学生ID");
        titleRow.createCell(2).setCellValue("学生姓名");
        titleRow.createCell(3).setCellValue("学生成绩");

        //遍历将数据放到excel列中
        for (Result result : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);

            dataRow.createCell(0).setCellValue(result.getResultId());
            dataRow.createCell(1).setCellValue(result.getStudentId());
            dataRow.createCell(2).setCellValue(result.getStudentName());
            dataRow.createCell(3).setCellValue(result.getResult());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("学生成绩名单".getBytes(),"iso-8859-1") + ".xls");

        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();


    }



}

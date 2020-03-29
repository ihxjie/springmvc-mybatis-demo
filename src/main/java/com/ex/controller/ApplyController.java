package com.ex.controller;

import com.ex.model.Apply;
import com.ex.model.Project;
import com.ex.model.Result;
import com.ex.service.ApplyService;
import com.ex.service.ProjectService;
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
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class ApplyController {
    private Logger logger = Logger.getLogger(ApplyController.class);

    @Resource
    private ApplyService applyService;
    @Resource
    private ProjectService projectService;


    @RequestMapping(value = "/sys/applylist/pass", method = RequestMethod.GET)
    public String getProjectlistpass(String workId,@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Project> projectList=null;
        projectList = projectService.getProjectByWorkId(workId);
        //使用PageInfo包装数据
        PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("projectList", projectList);
        return "projectapply";
    }

    @RequestMapping(value="/sys/applylist/list/{projectId}")
    public String getEnrollList(Model model, @PathVariable String projectId,@RequestParam(value = "page", defaultValue = "1") Integer page){
        System.out.println("0000000000"+projectId);
        PageHelper.startPage(page, 8);
        List<Apply> applyList = null;
        applyList=applyService.getApplyByProjectId(Integer.valueOf(projectId));
        PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("applyList", applyList);
        model.addAttribute("applyprojectId", projectId);
        return "applylist";
    }


    @RequestMapping(value="/sys/applylist/list.html")
    public String getApplyList(Model model, String personName){
        logger.info("getUserList ---- > goodsName: " + personName);
        List<Apply> applyList = null;
        try {
            applyList = applyService.getApplyList(personName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("applyList", applyList);
        return "projectapply";
    }

    @RequestMapping(value="/view/{applyId}",method= RequestMethod.GET)
    public String view(@PathVariable String applyId, Model model, HttpServletRequest request){
        logger.debug("view eno===================== "+applyId);
        Apply apply = new Apply();
        try {
            apply =applyService.getApplyById(applyId);
            logger.debug("view eno===================== "+apply.getApplyId());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(apply);
        return "appplyview";
    }

    @RequestMapping("/sys/apply/Controller/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Apply> list =applyService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("学生报名表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("报名号");
        titleRow.createCell(1).setCellValue("项目ID");
        titleRow.createCell(2).setCellValue("学生ID");
        titleRow.createCell(3).setCellValue("学生姓名");


        //遍历将数据放到excel列中
        for (Apply apply : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(apply.getApplyId());
            dataRow.createCell(1).setCellValue(apply.getProjectId());
            dataRow.createCell(2).setCellValue(apply.getPersonId());
            dataRow.createCell(3).setCellValue(apply.getPersonName());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("项目学生报名名单".getBytes(),"iso-8859-1") + ".xls");

        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }



}

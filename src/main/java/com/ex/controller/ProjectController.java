package com.ex.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.ex.model.Project;
import com.ex.model.Student;
import com.ex.service.ProjectService;
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
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;


@Controller
public class ProjectController {
    @Resource
    private ProjectService projectService;
    private Logger logger = Logger.getLogger(ProjectController.class);
    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    public String getProjectList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Project> projectList = projectService.getProjectList();
        //使用PageInfo包装数据
        PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("projectList", projectList);
        return "projectList";
    }

    @RequestMapping(value="/sys/projectList/looklist.html",method=RequestMethod.POST)
    public String viewproject(Model model,
                              @RequestParam(value="projectId",required=false) Integer projectId,
                              @RequestParam(value="page",required=false) String page) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        //紧跟的第一个select方法被分页
        List<Project> projectList = projectService.selectId(projectId);
        //使用PageInfo包装数据
        PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("projectList", projectList);
        return "projectList";
    }
    @RequestMapping(value="/sys/projectList/view/{projectId}",method=RequestMethod.GET)
    public String view(@PathVariable Integer projectId, Model model, HttpServletRequest request){
        logger.debug("view id===================== "+projectId);
        Project project = new Project();
        try {
            project =projectService.selectProjectId(projectId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(project);
        return "projectview";
    }

    @RequestMapping(value="/delProjects",method=RequestMethod.POST)
    @ResponseBody
    public Object delGoods(@RequestParam(value="list" ,required=false) List<Integer>list) throws Exception
    {
        boolean flag = true;
        for(Integer id : list) {
            if(!projectService.delProjectById(id))
            {
                flag = false;
            }
        }
        return JSONArray.toJSONString(flag);
    }

    @RequestMapping(value="/sys/projectList/modify/{projectId}",method=RequestMethod.GET)
    public String getProjectModify(@PathVariable Integer projectId,Model model,HttpServletRequest request){
        logger.debug("getProviderById typeId===================== "+projectId);
        Project project = new Project();
        try {
            project = projectService.selectProjectId(projectId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getProviderById studentId===================== "+project .getProjectId());
        model.addAttribute(project);
        return "updateproject";
    }
    @RequestMapping(value="/sys/projectList/modifysave.html",method=RequestMethod.POST)
    public String modifyProjectSave(Project project){
        logger.debug("modifyProjectSave id===================== "+project.getProjectId());
        try {
            if(projectService.updateByPrimaryKey(project)){
                return "redirect:/projectList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updateproject";
    }
    @RequestMapping("/sys/projectController/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Project> list =projectService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("实训项目表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("项目id");
        titleRow.createCell(1).setCellValue("负责方账号");
        titleRow.createCell(2).setCellValue("实训周期");
        titleRow.createCell(3).setCellValue("项目名称");
        titleRow.createCell(4).setCellValue("项目内容");
        titleRow.createCell(5).setCellValue("项目地址");
        titleRow.createCell(6).setCellValue("费用");

        //遍历将数据放到excel列中
        for (Project project : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(project.getProjectId());
            dataRow.createCell(1).setCellValue(project.getWorkId());
            dataRow.createCell(2).setCellValue(project.getPeriod());
            dataRow.createCell(3).setCellValue(project.getProjectTitle());
            dataRow.createCell(4).setCellValue(project.getProjectContent());
            dataRow.createCell(5).setCellValue(project.getProjectAddress());
            dataRow.createCell(6).setCellValue(project.getProjectPrice());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("实训项目名单".getBytes(),"iso-8859-1") + ".xls");


        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();


    }

    @RequestMapping(value="/Closeproject.json")
    @ResponseBody
    public Object adeluser(@RequestParam Integer projectId) {
        Project project = new Project();
        HashMap<String, String> resultMap = new HashMap<String, String>();

            try {
                if (projectService.updatestatus(projectId, 0) ) {
                    resultMap.put("result", "true");
                } else
                    resultMap.put("result", "false");
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping(value="/Openproject.json")
    @ResponseBody
    public Object deluser(@RequestParam Integer projectId){
        HashMap<String, String> resultMap = new HashMap<String, String>();
            try {
                if(projectService.updatestatus(projectId,1))
                    resultMap.put("result", "true");
                else
                    resultMap.put("result", "false");
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return JSONArray.toJSONString(resultMap);
    }
    @RequestMapping(value="/Juproject.json")
    @ResponseBody
    public Object JuProject(@RequestParam Integer projectId){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        try {
            if(projectService.updatestatus(projectId,-1))
                resultMap.put("result", "true");
            else
                resultMap.put("result", "false");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return JSONArray.toJSONString(resultMap);
    }
}

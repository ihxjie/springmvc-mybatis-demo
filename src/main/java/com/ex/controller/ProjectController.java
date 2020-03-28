package com.ex.controller;

import com.alibaba.fastjson.JSONObject;
import com.ex.dao.ApplyMapper;
import com.ex.dao.CompanyMapper;
import com.ex.dao.ProjectMapper;
import com.ex.dao.ReasonMapper;
import com.ex.model.Apply;
import com.ex.model.Project;
import com.ex.model.Reason;
import com.ex.model.StudentTable;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.asm.IModelFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
public class ProjectController {
    @Resource
    ProjectMapper projectMapper;
    @Resource
    ApplyMapper applyMapper;
    @Resource
    CompanyMapper companyMapper;
    @Resource
    ReasonMapper reasonMapper;

    @GetMapping(value = "enrollProject", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String enrollProject(@RequestParam("projectId") Integer projectId, HttpSession session){
        String studentId = session.getAttribute("username").toString();
        System.out.println(studentId);

        Apply a = applyMapper.selectEnrollInfo(studentId,projectId);

        if (a == null) {
            Apply apply = new Apply();
            apply.setProjectId(projectId);
            apply.setPersonId(studentId);
            apply.setPersonName(session.getAttribute("name").toString());
            apply.setStatus(0);
            apply.setIsStudent(1);
            System.out.println(apply);
            applyMapper.insertSelective(apply);
            return "报名成功！";
        }else{
            return "不要重复报名";
        }
    }

    @GetMapping(value = "project/getProjects",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getProjects(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                              @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                              @RequestParam(defaultValue = "", value = "keyword") String keyword){
        PageHelper.startPage(pageNum,pageSize);
        List<Project> projectList = projectMapper.selectProjectByNames(keyword);

        PageInfo pageInfo = new PageInfo(projectList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);
    }

    @GetMapping(value = "view/{projectId}", produces = "text/plain;charset=utf-8")
    public String view(@PathVariable Integer projectId, Model model, HttpSession session){

        String username = session.getAttribute("username").toString();
        List<Project> passedList = projectMapper.selectPassedProject(username);
        List<Project> rejectedList = projectMapper.selectRejectedProject(username);
        List<Project> applyingList = projectMapper.selectApplyingProject(username);
        List<StudentTable> studentTables = companyMapper.selectStudentTable(projectId);

        Project project = projectMapper.selectByPrimaryKey(projectId);
        model.addAttribute("studentTable", studentTables);
        model.addAttribute("applyingList", applyingList);
        model.addAttribute("passedList", passedList);
        model.addAttribute("rejectedList", rejectedList);
        model.addAttribute("project", project);
        return "company_view";
    }
    @GetMapping(value = "rejected/{projectId}", produces = "text/plain;charset=utf-8")
    public String rejected(@PathVariable Integer projectId, Model model, HttpSession session){

        String username = session.getAttribute("username").toString();
        Reason reason = reasonMapper.selectByPrimaryKey(projectId);
        List<Project> passedList = projectMapper.selectPassedProject(username);
        List<Project> rejectedList = projectMapper.selectRejectedProject(username);
        List<Project> applyingList = projectMapper.selectApplyingProject(username);

        Project project = projectMapper.selectByPrimaryKey(projectId);
        model.addAttribute("applyingList", applyingList);
        model.addAttribute("passedList", passedList);
        model.addAttribute("rejectedList", rejectedList);
        model.addAttribute("project", project);
        model.addAttribute("reason", reason.getRefuse());
        return "company_rejected";
    }
    @PostMapping(value = "add_new_project", produces = "text/plain;charset=utf-8")
    public String add_new_project(@ModelAttribute Project project, HttpSession session){
        String username = session.getAttribute("username").toString();
        project.setIsCompany(1);
        project.setWorkId(username);
        project.setStatus(0);
        projectMapper.insertSelective(project);
        Integer i = projectMapper.getID();
        return "redirect:/view/" + i;
    }
    @PostMapping(value = "resubmit", produces = "text/plain;charset=utf-8")
    public String resubmit(@ModelAttribute Project project){
        project.setStatus(0);
        projectMapper.updateByPrimaryKeySelective(project);
        reasonMapper.deleteByPrimaryKey(project.getProjectId());
        return "redirect:/view/" + project.getProjectId();
    }
    @PostMapping(value = "update_project", produces = "text/plain;charset=utf-8")
    public String update_project(@ModelAttribute Project project){
        projectMapper.updateByPrimaryKeySelective(project);
        return "redirect:/view/" + project.getProjectId();
    }
}

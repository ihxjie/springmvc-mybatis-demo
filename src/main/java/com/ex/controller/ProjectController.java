package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Project;
import com.ex.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProjectController {
    @Resource
    private ProjectService projectService;
    private Logger logger = Logger.getLogger(com.ex.controller.ProjectController.class);

    @RequestMapping(value = "/projectlist", method = RequestMethod.GET)
    public String getProjectlist(String projectTitle,@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Project> projectList = projectService.getProjectList(projectTitle);
        //使用PageInfo包装数据
        PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("projectList", projectList);
        return "projectlist";
    }

    public String getProjectllist(String projectTitle,@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Project> projectList = projectService.getProjectLiist(projectTitle);
        //使用PageInfo包装数据
        PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("projectList", projectList);
        return "projectlist";
    }

    //根据id查看
    @RequestMapping(value="/sys/projectlist/view/{projectId}",method=RequestMethod.GET)
    public String view(@PathVariable String projectId, Model model, HttpServletRequest request){
        logger.debug("projectId id===================== "+projectId);
        Project project = new Project();
        try {
            project =projectService.getProjectById(projectId);
            logger.debug("wwwwwwwwwwww ");
            logger.debug("view Pno===================== "+project.getProjectId());
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




    //修改
    @RequestMapping(value="/sys/projectlist/modify/{projectId}",method=RequestMethod.GET)
    public String getProjectModify(@PathVariable String projectId,Model model,HttpServletRequest request){
        logger.debug("getProviderById typeId===================== "+projectId);
        Project project = new Project();
        try {
            project = projectService.getProjectById(projectId);
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

    //保存修改
    @RequestMapping(value="/sys/projectList/modifysave.html",method=RequestMethod.POST)
    public String modifyProjectSave(Project project){
        logger.debug("modifyProjectSave id===================== "+project.getProjectId());
        try {
            if(projectService.updateByPrimaryKey(project)){
                return "redirect:/projectlist.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updateproject";
    }

    //删除
    @RequestMapping(value="/delProject",method=RequestMethod.POST)
    @ResponseBody
    public Object delProject(@RequestParam(value="ProjectId" ,required=true) String projectId)
    {
        boolean flag = true;
        if(!projectService.deleteByPrimaryKey(projectId))
        {
            flag = false;
        }
        return JSONArray.toJSONString(flag);
    }



    //判断是否存在
    @RequestMapping(value="/sys/projectlist/projectexist.json")
    @ResponseBody
    public Object ProgramIsExit(@RequestParam String projectTitle){
        logger.debug("cnameIsExit cname===================== "+projectTitle);
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isEmpty(projectTitle)){
            resultMap.put("projectTitle", "exist");
        }else{
            Project project = null;
            try {

                project =  projectService.selectProjectExist(projectTitle);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(null != project)
                resultMap.put("projectTitle", "exist");
            else
                resultMap.put("projectTitle", "noexist");
        }
        return JSONArray.toJSONString(resultMap);
    }



    //申报项目
    @RequestMapping(value="/sys/projectlist/add",method=RequestMethod.GET)
    public String addProject(@ModelAttribute("project") Project project){
        return "projectadd";
    }

    //确认添加
    @RequestMapping(value="/sys/projectlist/addsave",method=RequestMethod.POST)
    public String addProjectSave(Project project, HttpSession session, HttpServletRequest request){
        System.out.println("ggg"+project.getProjectTitle());
        try {
            if(projectService.insert(project)){
                return "redirect:/projectlist";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "projectadd";
    }






}


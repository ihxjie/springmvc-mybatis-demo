package com.ex.controller;

import com.ex.model.Reason;
import com.ex.model.Student;
import com.ex.service.ProjectService;
import com.ex.service.ReasonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReasonController {
    @Resource
    private ReasonService reasonService;
    private Logger logger = Logger.getLogger(ProjectController.class);
    @RequestMapping(value="/sys/projectRefuse/modifysave.html",method= RequestMethod.POST)
    public String addProjectrefuseSave(Reason reason, HttpSession session, HttpServletRequest request){
        try {
            if(reasonService.insert(reason)){
                return "redirect:/projectList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "404";
    }
}

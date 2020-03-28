package com.ex.controller;

import com.ex.model.Feedback;
import com.ex.model.Student;
import com.ex.service.ApplyService;
import com.ex.service.FeedbackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;
    private Logger logger = Logger.getLogger(FeedbackController.class);
    @RequestMapping(value = "/feedbackList", method = RequestMethod.GET)
    public String getFeedbackList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Feedback> feedbackList = feedbackService.getFeedbackList();
        //使用PageInfo包装数据
        PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(feedbackList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("feedbackList", feedbackList);
        return "feedbackList";
    }

    @RequestMapping(value="/sys/feedbackList/looklist.html",method=RequestMethod.POST)
    public String viewfeedback(Model model,
                              @RequestParam(value="teacherId",required=false) String teacherId,
                              @RequestParam(value="page",required=false) String page) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        //紧跟的第一个select方法被分页
        List<Feedback> feedbackList = feedbackService.selectId(teacherId);
        //使用PageInfo包装数据
        PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(feedbackList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("feedbackList", feedbackList);
        return "feedbackList";
    }

    @RequestMapping(value = "/sys/feedbackList/view/{teacherId}", method = RequestMethod.GET)
    public String view(@PathVariable String teacherId, Model model, HttpServletRequest request) {
        logger.debug("view id===================== " + teacherId);
        Feedback feedback = new Feedback();
        try {
            feedback = feedbackService.lookTeacherId(teacherId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(feedback);
        return "feedbackview";
    }
}

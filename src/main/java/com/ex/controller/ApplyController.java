package com.ex.controller;

import com.alibaba.fastjson.JSONObject;
import com.ex.dao.ApplyMapper;
import com.ex.dao.FeedbackMapper;
import com.ex.dao.ProjectMapper;
import com.ex.model.Apply;
import com.ex.model.Feedback;
import com.ex.model.Project;
import com.ex.model.SimplyApply;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
public class ApplyController {

    @Resource
    ApplyMapper applyMapper;
    @Resource
    ProjectMapper projectMapper;
    @Resource
    FeedbackMapper feedbackMapper;

    @GetMapping(value = "apply/getApply", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getApply(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                              @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                              @RequestParam(defaultValue = "", value = "keyword") String keyword,
                              HttpSession session) {
        String studentId = session.getAttribute("username").toString();

        PageHelper.startPage(pageNum,pageSize);
        List<SimplyApply> applyList = applyMapper.getStudentApply(studentId);

        PageInfo pageInfo = new PageInfo(applyList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);


    }
    @GetMapping("payfor/{applyId}")
    public String payfor(@PathVariable Integer applyId, Model model){
        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        Project project = projectMapper.selectByPrimaryKey(apply.getProjectId());
        model.addAttribute("projectTitle", project.getProjectTitle());
        model.addAttribute("projectContent", project.getProjectContent());
        model.addAttribute("projectPrice", project.getProjectPrice());
        model.addAttribute("applyId", applyId);
        return "payfor";
    }
    @GetMapping(value = "pay", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String pay(@RequestParam Integer applyId){

        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        if (apply.getStatus() == 0){
            apply.setStatus(1);
            apply.setApplyId(applyId);
            applyMapper.updateByPrimaryKeySelective(apply);
            return "缴费成功";
        }
        return "缴费失败，您已经交过了";
    }
    @GetMapping(value = "drop", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String drop(@RequestParam Integer applyId, HttpSession session){
        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        Project project = projectMapper.selectByPrimaryKey(apply.getProjectId());
        String username = session.getAttribute("username").toString();
        if (username.equals(apply.getPersonId())){
            applyMapper.deleteByPrimaryKey(applyId);
            return "您已成功退选：" + project.getProjectTitle();
        }
        return "非法操作，请检查是否登录";
    }
    @GetMapping(value = "teacher_evaluate", produces = "text/plain;charset=utf-8")
    public String teacher_evaluate(@RequestParam Integer applyId, Model model, HttpSession session){
        Apply apply = applyMapper.selectByPrimaryKey(applyId);

        List<Apply> teacherApply = applyMapper.getTeacherApply(apply.getProjectId());
        model.addAttribute("applyId", applyId);
        if (teacherApply.size() != 0){
            model.addAttribute("teacherApply", teacherApply);
            model.addAttribute("teacherName", teacherApply.get(0).getPersonName());
            model.addAttribute("teacherId", teacherApply.get(0).getPersonId());
            session.setAttribute("projectId", apply.getProjectId());
            return "feedback";
        }
        model.addAttribute("info", "未有老师报名，无法评价");
        return "enrolment";
    }
    /*@PostMapping(value = "single_evaluate")
    public String single_evaluate(String teacherId, Integer option1, Integer option2,Integer option3,
                                  Integer option4,Integer option5,Integer option6,Integer option7,
                                  Integer option8, HttpSession session){
        Feedback feedback = new Feedback();
        feedback.setOption1(option1);
        feedback.setOption2(option2);
        feedback.setOption3(option3);
        feedback.setOption4(option4);
        feedback.setOption5(option5);
        feedback.setOption6(option6);
        feedback.setOption7(option7);
        feedback.setOption8(option8);
        feedback.setTeacherId(teacherId);
        System.out.println(feedback);
        return "feedback";

    }*/
    @PostMapping(value = "single_evaluate", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String single_evaluate(@ModelAttribute Feedback feedback, HttpSession session){

        System.out.println(feedback);

        String studentId = session.getAttribute("username").toString();
        Integer projectId = Integer.parseInt(session.getAttribute("projectId").toString());

        Feedback f = feedbackMapper.getEvaluatedInfo(studentId,projectId,feedback.getTeacherId());
        if (f == null){
            feedback.setStudentId(studentId);
            feedback.setProjectId(projectId);
            feedbackMapper.insertSelective(feedback);
            return "评价成功！";
        }

        return "无需重复评价";

    }
}

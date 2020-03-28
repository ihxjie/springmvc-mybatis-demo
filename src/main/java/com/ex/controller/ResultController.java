package com.ex.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ex.dao.ProjectMapper;
import com.ex.dao.ResultMapper;
import com.ex.model.Grade;
import com.ex.model.Project;
import com.ex.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ResultController {

    @Resource
    ResultMapper resultMapper;
    @Resource
    ProjectMapper projectMapper;

    @GetMapping(value = "/getStudentResult", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getStudentResult(HttpSession session){
        String studentId = session.getAttribute("username").toString();
        List<Grade> grades = resultMapper.selectStudentResult(studentId);

        return JSONObject.toJSONString(grades, SerializerFeature.WriteMapNullValue);
    }
}

package com.ex.controller;

import com.ex.service.BorderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;


@Controller
@RequestMapping("/border")
public class BorderController
{

    @Resource
    BorderService borderService;

    @RequestMapping("/getborder")
    public String getborder(HttpSession session) {
        List<Border> list = borderService.getAllBorder();
        session.setAttribute("blist", list);
        System.out.println(list.size());
        for (Border border : list) {
            System.out.println(border);
        }
        return "border";
    }
    @GetMapping(value = "/getBorder",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getBorder(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                             @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                             @RequestParam(defaultValue = "", value = "keyword") String keyword){
        PageHelper.startPage(pageNum,pageSize);
        List<Border> borderList = borderService.findBorderByNames(keyword);
        PageInfo pageInfo = new PageInfo(borderList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);
    }
    @GetMapping("/delete/{borderId}")
    public String delete(@PathVariable Integer borderId){
        borderService.delBorder(borderId);
        return "redirect:/BorderBackstageSys";
    }
    @PostMapping("/insert")
    public String insert(@ModelAttribute Border border){
        borderService.addBorder(border);
        return "redirect:/BorderBackstageSys";
    }
}

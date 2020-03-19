package com.ex.controller;

import com.alibaba.fastjson.JSONObject;
import com.ex.service.OrderBasisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
@RequestMapping("/orderBasis")
public class OrderBasisController {

    @Resource
    OrderBasisService orderBasisService;

    @GetMapping(value = "/getOrderBasis",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getOrderBasis(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                             @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                             @RequestParam(defaultValue = "", value = "keyword") String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderBasis> orderBasisList = orderBasisService.selectOrderBasisByNames(keyword);
        PageInfo pageInfo = new PageInfo(orderBasisList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);
    }
    @RequestMapping("/delete/{orderId}")
    public String delete(@PathVariable Integer orderId){
        orderBasisService.deleteByPrimaryKey(orderId);
        return "redirect:/OrderBasisBackstageSys";
    }
}

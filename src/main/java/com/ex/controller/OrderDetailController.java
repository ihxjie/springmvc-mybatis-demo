package com.ex.controller;

import com.alibaba.fastjson.JSONObject;
import com.ex.model.OrderBasis;
import com.ex.model.OrderDetail;
import com.ex.service.OrderBasisService;
import com.ex.service.OrderDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Resource
    OrderDetailService orderDetailService;

    @GetMapping(value = "/getOrderDetail",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getOrderDetail(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                                @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                                @RequestParam(defaultValue = "", value = "keyword") String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderDetail> orderDetailList = orderDetailService.selectByNames(keyword);
        PageInfo pageInfo = new PageInfo(orderDetailList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);
    }
    @RequestMapping("/delete/{orderId}")
    public String delete(@PathVariable Integer orderId){
        orderDetailService.deleteByPrimaryKey(orderId);
        return "redirect:/OrderDetailBackstageSys";
    }
}

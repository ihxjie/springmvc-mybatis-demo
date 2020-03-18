package com.ex.controller;

import com.alibaba.fastjson.JSONObject;
import com.ex.model.Product;
import com.ex.model.ProductType;
import com.ex.service.ProductTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
@RequestMapping("/type")
public class ProductTypeController {
    @Resource
    ProductTypeService productTypeService;

    @GetMapping(value = "/getType",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getType(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                             @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                             @RequestParam(defaultValue = "", value = "keyword") String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductType> productTypeList = productTypeService.findTypeByNames(keyword);
        PageInfo pageInfo = new PageInfo(productTypeList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);
    }

    @RequestMapping("/delete/{typeId}")
    public String delete(@PathVariable Integer typeId){
        productTypeService.delProductType(typeId);
        return "redirect:/TypeBackstageSys";
    }
    @PostMapping("/insert")
    public String insert(@ModelAttribute ProductType productType){
        productTypeService.addProductType(productType);
        return "redirect:/TypeBackstageSys";
    }

}

package com.ex.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ex.model.Product;
import com.ex.model.User;
import com.ex.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/findProduct/{keyword}")
    @ResponseBody
    public List<Product> getProduct(@PathVariable String keyword){
        return productService.findProductByName(keyword);
    }

    @PostMapping(path = "/add")

    public String add(@ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:/ProductBackstageSys";
    }

    @GetMapping(value = {"/list/{pname}","/list"})
    public String pageList(HttpSession session, @RequestParam(defaultValue = "1",required = true,value = "pageNo")Integer pageNo, @PathVariable(required = false) String pname){
        Object email = session.getAttribute("email");
        System.out.println("///////////" + email);
        if(email == null){
            System.out.println("/////////");
            session.setAttribute("email","游客");
        }
        Integer pageSize = 9;
        PageHelper.startPage(pageNo, pageSize);
        List<Product> productsList;
        if (pname == null || pname.length() == 0 || pname.equals("null"))
            productsList = productService.findAllProduct();
        else
            productsList = productService.findProductByName(pname);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productsList);
        session.setAttribute("pageInfo", pageInfo);
        return "product";
    }
    @GetMapping("/listbyType/{type}")
    public String pageListbyType(HttpSession session,@RequestParam(defaultValue = "1",required = true,value = "pageNo")Integer pageNo,@PathVariable(required = false) Integer type){
        Integer pageSize = 9;
        PageHelper.startPage(pageNo, pageSize);
        List<Product> productsList;
        if (type == null || type.equals("null"))
            productsList = productService.findAllProduct();
        else
            productsList = productService.findProductByType(type);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productsList);
        session.setAttribute("pageInfo", pageInfo);
        return "product";
    }


    @RequestMapping("/jsp")
    public String jsp(){
        return "regist";
    }

    @GetMapping(value = "/test",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getProduct(){
        PageHelper.startPage(1,3);
        List<Product> productList = productService.findAllProduct();
        System.out.println("6");
        PageInfo pageInfo = new PageInfo(productList);
        System.out.println(JSON.toJSONString(pageInfo));
        return JSON.toJSONString(pageInfo);

    }
    @GetMapping(value = "/getProducts",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getProducts(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                             @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                             @RequestParam(defaultValue = "", value = "keyword") String keyword){
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productService.findProductByName(keyword);
        PageInfo pageInfo = new PageInfo(productList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);
    }
    @GetMapping("/toSingle/{pid}")
    public String toProduct(@PathVariable(name = "pid")Integer productId, HttpSession session){
        Product product = productService.findProductById(productId);
        session.setAttribute("pid",productId);
        session.setAttribute("product",product);
        return "single";
    }

    @RequestMapping("/notfind")
    public String to404(){
        return "404";
    }
    @GetMapping("/{product_id}")
    public ModelAndView getProductById(@PathVariable Integer product_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",productService.findProductById(product_id));
        modelAndView.setViewName("adminProductSingle");
        return modelAndView;

    }
    @GetMapping("/new")
    public String newProduct(){
        return "adminProductSingle";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        productService.updProduct(product);
        return "redirect:/ProductBackstageSys";
    }
    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable Integer productId){
        System.out.println(productId);
        productService.delProduct(productId);
        return "redirect:/ProductBackstageSys";
    }
}

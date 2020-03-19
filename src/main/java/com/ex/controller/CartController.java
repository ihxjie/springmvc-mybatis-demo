package com.ex.controller;

import com.ex.service.CartService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @RequestMapping("/postcart")
    public @ResponseBody
    String postCart(@RequestBody Cart cart){
        int num = cartService.insert(cart);
        if(num == 0)
            return "fail";
        else {
            return "success";
        }
    }

    @RequestMapping("/getcart")
    public String getPostcat(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        System.out.println(uid);
        List<CartList> cartList = cartService.selectCartListByUserId(uid);
        for(CartList cart : cartList){
            System.out.println(cart);
        }
        session.setAttribute("cartList",cartList);
        System.out.println(cartList.size());
        return "checkout";
    }

    @RequestMapping("/deletecart/{cid}")
    public String deleteCart(@PathVariable(name = "cid")Integer cartid){
        System.out.println(cartid);
        int num = cartService.deleteByPrimaryKey(cartid);
        System.out.println(num);
        return "redirect:/cart/getcart";
    }
}

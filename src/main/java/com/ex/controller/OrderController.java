package com.ex.controller;

import com.ex.model.CartList;
import com.ex.model.FollowList;
import com.ex.model.OrderBasis;
import com.ex.model.OrderDetail;
import com.ex.service.CartService;
import com.ex.service.OrderBasisService;
import com.ex.service.OrderDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderBasisService orderBasisService;

    @Resource
    private OrderDetailService orderDetailService;

    @Resource
    private CartService cartService;

    @RequestMapping("/postorder")
    public @ResponseBody
    String postOrder(HttpSession session){
        List<CartList> list = (List<CartList>) session.getAttribute("cartList");
        OrderBasis orderBasis = new OrderBasis();
        OrderDetail orderDetail = new OrderDetail();
        for(CartList cl : list){
            Integer randomNum = (int) System.currentTimeMillis();
            String Money = String.valueOf((Integer.parseInt(cl.getPurchaseQuantity()) * cl.getProductCurrentPrice().intValue()));
            System.out.println(Money);
            orderBasis.setOrderMoney(Money);
            orderBasis.setOrderStatus("未付款");
            orderBasis.setOrderId(randomNum);
            orderBasis.setUserId(cl.getUserId());
            orderDetail.setProductId(cl.getProductId());
            orderDetail.setOrderId(randomNum);
            orderDetail.setPurchaseQuantity(Integer.parseInt(cl.getPurchaseQuantity()));
            int num1 = orderBasisService.insert(orderBasis);
            int num2 = orderDetailService.insertSelective(orderDetail);
            int num3 = cartService.deleteByPrimaryKey(cl.getCartId());
            System.out.println(num1 + " ////// " + num2 + "/////" + num3);
        }
        return "success";
    }

    @RequestMapping("/getorder")
    public String getorder(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        System.out.println(uid);
        List<OrderBasis> orderBasisList = orderBasisService.selectByUserIdOrderBasis(uid);
        for(OrderBasis orderBasis : orderBasisList){
            System.out.println(orderBasis);
        }
        session.setAttribute("OrderBasisList",orderBasisList);
        System.out.println(orderBasisList.size());
        return "order";
    }

    @RequestMapping("/deleteorder/{oid}")
    public String deleteCart(@PathVariable(name = "oid")Integer orderid){
        System.out.println(orderid);
        int num = orderBasisService.deleteByPrimaryKey(orderid);
        System.out.println(num);
        return "redirect:/order/getorder";
    }

    @RequestMapping("/updateorder/{oid}")
    public String updateorder(@PathVariable(name = "oid")Integer orderid){
        System.out.println(orderid);
        OrderBasis orderBasis = new OrderBasis();
        orderBasis.setOrderStatus("已付款");
        orderBasis.setOrderId(orderid);
        int num = orderBasisService.updateByPrimaryKeySelective(orderBasis);
        System.out.println(num);
        return "redirect:/order/getorder";
    }
}

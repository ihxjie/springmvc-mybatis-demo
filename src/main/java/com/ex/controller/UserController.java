package com.ex.controller;

import com.ex.model.User;
import com.ex.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/checkEmailUnique")
    public @ResponseBody
    String testAjax(@RequestBody String email) {
        JSONObject mapJson = JSONObject.fromObject(email);
        String strEmail = mapJson.getString("userEmail");
        System.out.println(strEmail);
        System.out.println("tA执行了");
        List<User> userList = null;
        userList = userService.selectUserByEmail(strEmail);
        System.out.println(userList);
        System.out.println(userList.size());
        if (userList.size() == 0) {
            return "true";
        } else {
            return "false";
        }
    }

    @PostMapping("/postUser")
    public String postUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        System.out.println(email + password);
        User user = new User();
        user.setUserEmail(email);
        user.setUserPassword(password);
        userService.insertUser(user);
        return "login";
    }

    @PostMapping("/updateUser")
    public @ResponseBody
    String updataUser(@RequestBody User user) {
        System.out.println(user);
        userService.updateByPrimaryKeySelective(user);
        return "success";
    }

    @PostMapping("/checkUser")
    public @ResponseBody
    String cherkUser(@RequestBody User user, HttpSession session) {
        System.out.println("执行了");
        System.out.println(user);
        List<User> list = userService.selectUserByEmail(user.getUserEmail());
        System.out.println(list.size());
        if (list.size() != 0 && list.get(0).getUserPassword().equals(user.getUserPassword())) {
            System.out.println("22");
            session.setAttribute("uid", list.get(0).getUserId());
            session.setAttribute("email", user.getUserEmail());
            return "success";
        } else {
            System.out.println("11");
            return "fail";
        }
    }

    @RequestMapping("/toProduct")
    public String toProduct() {
        return "product";
    }

    @RequestMapping("/tologin")
    public String tologin() {
        return "login";
    }

    @RequestMapping("/toUserinform")
    public String toUserinform() {
        return "userinform";
    }

    @RequestMapping("/getout")
    public String getout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:/product/list/null";
    }
    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable Integer userId){
        userService.deleteByUserId(userId);
        return "redirect:/UserBackstageSys";
    }

    @GetMapping(value = "/getUser",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getUser(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                          @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                          @RequestParam(defaultValue = "", value = "keyword") String keyword){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userService.selectUserByEmail(keyword);
        PageInfo pageInfo = new PageInfo(userList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return com.alibaba.fastjson.JSONObject.toJSONString(pageInfo, WriteMapNullValue);
    }

}
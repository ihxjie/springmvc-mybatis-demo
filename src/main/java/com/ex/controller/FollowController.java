package com.ex.controller;

import com.ex.service.FollowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/follow")
public class FollowController {

    @Resource
    private FollowService followService;

    @RequestMapping("/postfollow")
    public @ResponseBody
    String postCart(@RequestBody Follow follow){
        int num = followService.insert(follow);
        if(num == 0)
            return "fail";
        else {
            return "success";
        }
    }

    @RequestMapping("/getfollow")
    public String getfollow(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        System.out.println(uid);
        List<FollowList> followLists = followService.selectfollowListByUserId(uid);
        for(FollowList cart : followLists){
            System.out.println(cart);
        }
        session.setAttribute("FollowList",followLists);
        System.out.println(followLists.size());
        return "wishlist";
    }

    @RequestMapping("/deletefollow/{fid}")
    public String deleteCart(@PathVariable(name = "fid")Integer followid){
        System.out.println(followid);
        int num = followService.deleteByPrimaryKey(followid);
        System.out.println(num);
        return "redirect:/follow/getfollow";
    }
}

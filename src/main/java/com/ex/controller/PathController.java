package com.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/handle")
public class PathController {

    @GetMapping("/{url}")
    public String redirect(@PathVariable String url){
        return "redirect:/" + url;
    }
}

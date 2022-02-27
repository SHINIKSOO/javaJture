package com.javajocchyo.study.controller;


import com.javajocchyo.study.domain.Member;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloViewController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","신익수");
        return "hello";
        //ViewResolver
    }

    @GetMapping("/hello2")
    @ResponseBody
    public Member hello2(Model model){
        model.addAttribute("data","신익수");


        return new Member(1L,"익수다");
    }
}

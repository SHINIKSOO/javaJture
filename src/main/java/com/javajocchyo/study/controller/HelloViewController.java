package com.javajocchyo.study.controller;


import com.javajocchyo.study.domain.Member;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloViewController {

    @GetMapping("/hello")
    public String hello(Model model){
       // model.addAttribute("data","신익수");
        return "hello";
        //ViewResolver
    }

    @GetMapping("/hello2")
    @ResponseBody
    public Member hello2(Model model){
        model.addAttribute("data","신익수");


        return new Member(1L,"익수다");
    }

    /* 숙제 */

    @GetMapping("/diffTransmission")
    public String checkMetgod(@RequestParam(required=false) String str, Model model) {
        model.addAttribute("data",str);

        System.out.println("RequseParam = " + str);
        return "hello";

    }

    @GetMapping("/diffPath/{num}")
    public String checkMethod2(@PathVariable String num) {
        System.out.println("PathVariable =" + num );
        return "hello";
    }




}

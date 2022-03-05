package com.javajocchyo.study.controller;


import com.javajocchyo.study.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/*

퍼사트패턴 : 코드레벨로 작성하기 /
Slf4j :  인터페이스
log4j log4j2 logback(스프링부트디폴트)
 */


@Slf4j
@RestController
public class MemberController {

    @GetMapping("/study/path-varialbe/{name}")
    public String pathVariable(@PathVariable String name){
        log.info("name : {}", name);

        return "Ok";
    }


    @GetMapping("/study/servlet-param")
    public String servletParam(HttpServletRequest request){
        String name = request.getParameter("name");

        log.info("name {}",name);
        return "Ok";
    }



    @GetMapping("/study/request-param")
    public String requestParam(@RequestParam(required = false, defaultValue = "default@shiniksoo") String name){


        log.info("name {}",name);
        return "Ok";
    }



    @GetMapping("/study/model-attribute")
    public String modelAttribute(@ModelAttribute MemberDto dto){
        log.info(">>>>>>>memberDto {}", dto);
        return "Ok";

    }


    @PostMapping("/study/request-body/string")
    public String requstbodyString( @RequestBody String body){

        log.info("body>>>{}",body);
        return "Ok";


    }


    @PostMapping("/study/request-body/param")
    public String requstbodyParam( @ModelAttribute MemberDto dto){

        log.info("body>>>{}",dto);
        return "Ok";


    }


    @PostMapping("/study/request-body/object")
    public String requstbodyObject( @RequestBody MemberDto dto){

        log.info("body>>>{}",dto);
        return "Ok";


    }

}

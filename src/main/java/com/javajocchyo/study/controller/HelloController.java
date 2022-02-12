package com.javajocchyo.study.controller;


import com.javajocchyo.study.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



//계층(Layer)관점 @Service @Repository @Controller



@RestController
//싱글톤객체
public class HelloController {
    //스프링 의존성 주입 방법
    // field injection, setter injection,operator injection, ??





   // @Autowired //주입
    private CalculatorService calculatorService; //멤버필드


//    @Autowired
//    public void setCalculatorService(CalculatorService service){
//        this.calculatorService = service;
//    }

    @Autowired
    public HelloController(CalculatorService service){
        this.calculatorService = service;

    }
    
    @GetMapping("/api/hello")
    public String hello(){
        return "hello world !!!";
    }

//    @GetMapping("/api/add")
//    public int testAdd(){
//        Calculator calculator = new Calculator();
//        return calculator.add(3,5);
//    }

    //Http Status Code
    // 4xx - 클라이언트 오류
    // 5xx - 서버측오류
    // controller의 역할 -> 외부 API 인터페이스
    // -> 자신의 역할 외에 다른 일은 다른 녀석에게 시킨다!
    @GetMapping("/calc/add")
    public int add(@RequestParam int x, @RequestParam int y){
        System.out.println("calculatorService = " + calculatorService);
        System.out.println("this = " + this);
       
        return calculatorService.add(x,y);

    }

    @GetMapping("/calc/minus")
    public int minus(@RequestParam int x, @RequestParam int y){
        System.out.println("calculatorService = " + calculatorService);
        System.out.println("this = " + this);
       // CalculatorService calculatorService = new CalculatorService();
        return calculatorService.minus(x,y);

    }
}

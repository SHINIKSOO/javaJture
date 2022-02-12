package com.javajocchyo.study.service;


import com.javajocchyo.study.model.Calculator;
import org.springframework.stereotype.Service;

@Service //@Component 포함되었음 서비스 기능을 수행한다는 논리적인 의미만 부여
public class CalculatorService {

    public int add(int x,int y) {


        //클래스 vs 객체
        // 클래스 : 붕어빵 틀
        // 객체 : 붕어빵, 여러개 만들 수 있다.
        return x+y;
    }

    public int minus(int x,int y){
      return x-y;
    }


}

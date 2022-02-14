package com.javajocchyo.study.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTest {


  //  @Test
   // void testAdd(){
        Calculator calculator = new Calculator();
       // int res = calculator.add(3,4);
       // System.out.println(res);
      //  Assertions.assertEquals(8,res);
     //   org.assertj.core.api.Assertions.assertThat(res).isEqualTo(8);

        //AssertJ는 메소드 체이닝 방식
        //타입 체크도 가능하다.
        //Junit에 비해 가독성이 훨씬 좋아짐
   // }
    @Disabled
    @Test
    void testMinus(){
        Calculator calculator = new Calculator();
        int res = calculator.minus(4, 3);
        Assertions.assertEquals(1,res);
    }

    @Test
    void testMultifly(){
        //Given
         /* 테스트를 위한 준비
         *
         *  */

        //When
        /* 테스트를 하려고 하는 내용 */

        //Then 동작확인
        Calculator calculator = new Calculator();
        int res = calculator.multifly(3,4);
        Assertions.assertEquals(12,res);
        org.assertj.core.api.Assertions.assertThat(res).isEqualTo(12);
    }

    @Test
    void testDivide(){
        Calculator calculator = new Calculator();
        int res = calculator.divide(8,2);
        Assertions.assertEquals(4,res);
        org.assertj.core.api.Assertions.assertThat(res).isEqualTo(4);

    }



    @Disabled
    @Test
    void testDivide2(){
        Calculator calculator = new Calculator();
        int x = 10;
        int y = 2;
       // int res = hello.divide(x,y);
        //Assertions.assertEquals(4,res);
        //org.assertj.core.api.Assertions.assertThat(res).isEqualTo(4);

        //Lambda Expression since java8
        Executable executable = () -> calculator.divide(x, y);
        Assertions.assertThrows(ArithmeticException.class,  executable);

    }


    @Test
    void testDivideByzero(){
        Calculator calculator = new Calculator();
        int x = 10;
        int y = 0;
       int res = calculator.divide(x, y);

      //  Assertions.assertEquals(0,res);
        org.assertj.core.api.Assertions.assertThat(res).isEqualTo(0);

    }

    @Test
    void testDivideOk(){
        Calculator calculator = new Calculator();
        int x =0;
        int y = 10;
        int res = calculator.divide(x,y);


        org.assertj.core.api.Assertions.assertThat(res).isEqualTo(0);
    }

}

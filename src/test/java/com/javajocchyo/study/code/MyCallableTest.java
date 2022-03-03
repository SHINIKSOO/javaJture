package com.javajocchyo.study.code;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

class MyCallableTest {

    @Test
    void call_0() {
        // 메소드 레퍼런스(참조)
        IntBinaryOperator operator = Math::min;

        // Type : Primitive Type, Wrapper Type, Reference Type
        // int, long, Integer, Long, String, Object
        // Generic (Java 1.5)
        Supplier<Integer> supplier = () -> 10;
        System.out.println("supplier.get() = " + supplier.get());
    }

    @Test
    void call_1() {
        System.out.println(">>> MyCallableTest.call_1()");
        Callable callable = new MyCallable();
        callable.call();
        System.out.println(">>> this 2 = " + this);
        System.out.println(">>> callable = " + callable);
    }

    @Test
    void call_2() {
        System.out.println(">>> MyCallableTest.call_2()");
        Callable callable = new Callable() { // 익명 (구현) 클래스
            @Override
            public void call() {
                System.out.println(">>> this 1 = " + this);
            }
        };
        callable.call();
        System.out.println(">>> this 2 = " + this);
        System.out.println(">>> callable = " + callable);
    }

    @Test
    void call_3() {
        System.out.println(">>> MyCallableTest.call_3()");

        // 람다식 = 함수형 프로그래밍 관점
        // 람다 : 익명 구현 클래스와 유사한 객체다?
        // 람다 : this가 익명 구현 클래스와 다르다.
        // 람다 캡처링 : 람다가 실행될 때, 메모리 동작
        // 람다 : 구현 대상 인터페이스의 메소드가 1개여야 한다.
        Callable callable = () -> System.out.println(">>> this 1 = " + MyCallableTest.this);
        callable.call();
        System.out.println(">>> this 2 = " + this);
        System.out.println(">>> callable = " + callable);
    }

    @Test
    void runnable() {
        Runnable runnable = () -> System.out.println("running....");
        runnable.run();


    }

    @Test
    void supplier(){
        Supplier<String> supplier = new Supplier<>(){
            @Override public String get(){
                return "supplier";

            }
        };
    }

      @Test
    void consumer(){
        Consumer<Object> consumer1 = i -> System.out.println("i1");
          Consumer<Object> consumer2 = i -> System.out.println("i2");
          consumer2.accept(5555);
        consumer1.accept(9999);

        consumer1.andThen(consumer2).accept(9999);
      }

   @Test
    void function() {
       Function<Integer, Boolean> func = i -> i > 0;

       Boolean res1 = func.apply(0);
       System.out.println(res1);
   }

   @Test
           void function2(){
       Function<Integer, Integer> multiply = (value) -> value * 2;
       Function<Integer, Integer> add      = (value) -> value + 3;

       System.out.println("multiply.apply(5) = " + multiply.apply(5));

       System.out.println("multiply.compose(add).apply(4) = " + multiply.compose(add).apply(4));

       Function<Integer, Integer> addThenMultiply = multiply.compose(add);

       Integer result1 = addThenMultiply.apply(3);
       System.out.println(result1);

   }


   /* 옵셔널 */
    @Test
    void optional(){
        //정적 팩토리 메소드 패턴(디자인패턴)
        String s = "Study";
        Optional<String> str = Optional.of(s);
        Optional<String> str2 = Optional.ofNullable(s);
        String txt = str2.orElse(""); //종단메소드
        //Optional<Object> str3 = Optional.empty();

        System.out.println("str3 = " + txt);

    }












}
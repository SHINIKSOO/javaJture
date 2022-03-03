package com.javajocchyo.study.code;


import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;

@FunctionalInterface // 함수형 인터페이스
public interface Callable {


    void call();

    // Java 1.8 변경사항 : 인터페이스에도 default 메소드와 static 메소드를 사용할 수 있다.
    default void runDefault() {

    }

    static void runStatic() {

    }
}
package com.javajocchyo.study.domain;


// domain : 비지니스 도메인, 업무 영역


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
public class Member {
    //field(멤버변수)
    private Long id; //primitive Type vs Wrapper Type
    private String name;

    public Member() {

    }

    public Member(long l, String 익수다) {
        id=l;
        name =익수다;
    }
}

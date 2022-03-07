package com.javajocchyo.study.domain;


// domain : 비지니스 도메인, 업무 영역




//JPA ( Java Persistence API) 방식
// 스프링 표준 ORM ----> 객체-관계매핑




import lombok.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity // Id필수 선언, 기본 생성자가 있어야 함.
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    //field(멤버변수)

    @Id @GeneratedValue
    private Long id; //primitive Type vs Wrapper Type

    private String name;



    public Member(String name){
        this.name = name;
    }
}

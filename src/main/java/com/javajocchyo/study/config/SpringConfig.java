package com.javajocchyo.study.config;


import com.javajocchyo.study.repository.JdbcMemberRepository;
import com.javajocchyo.study.repository.JdbcTemplateMemberRepository;
import com.javajocchyo.study.repository.MemberRepository;
import com.javajocchyo.study.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


//구현체 주입방식
//1. @Component로 지정된 구현체를 주입
//2. @Bean으로 지정된 메소드로 구현체 주입


//   Open   Close   Principal  확장에는 열려있고, 수정에는 닫혀있다.   새로운 코드가 추가 될 때, 기존 소스에는 영향이 있으면 안된다.






@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memberMemberRepository(DataSource dataSource){
    //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}


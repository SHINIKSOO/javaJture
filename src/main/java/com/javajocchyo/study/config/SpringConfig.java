package com.javajocchyo.study.config;


import com.javajocchyo.study.domain.Member;
import com.javajocchyo.study.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


//구현체 주입방식
//1. @Component로 지정된 구현체를 주입
//2. @Bean으로 지정된 메소드로 구현체 주입


//   Open   Close   Principal  확장에는 열려있고, 수정에는 닫혀있다.   새로운 코드가 추가 될 때, 기존 소스에는 영향이 있으면 안된다.






@Configuration
public class SpringConfig {

   // @Bean
    public MemberRepository memberMemberRepository(EntityManager em){
    //return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);

    }

}


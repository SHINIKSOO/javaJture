package com.javajocchyo.study.config;


import com.javajocchyo.study.repository.MemberRepository;
import com.javajocchyo.study.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memberMemberRepository(){
        return new MemoryMemberRepository();
    }
}

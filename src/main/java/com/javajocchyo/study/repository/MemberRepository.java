package com.javajocchyo.study.repository;


import com.javajocchyo.study.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//인터페이스의 역할 : 규격,명세,스펙
public interface MemberRepository {

    Member save(Member member);

    Optional<Member>  findById(Long id);
    Optional<Member> findByName(String name);

    List<Member> findAll();

    //java 1.8에 추가 된 것
    //인터페이스 default, static
    //Optional,Stream,Lambda



}

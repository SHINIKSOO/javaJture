package com.javajocchyo.study.repository;

import com.javajocchyo.study.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaRepository extends  MemberRepository, JpaRepository<Member,Long> {


    @Override
    Optional<Member> findByName(String name);
}

package com.javajocchyo.study.service;

import com.javajocchyo.study.domain.Member;
import com.javajocchyo.study.repository.MemberRepository;
import com.javajocchyo.study.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

//@SpringBootTest
class MemberServiceTest {
//    @Autowired
//    MemberService memberService;
//    @Autowired
//    MemoryMemberRepository repository;



      MemoryMemberRepository repository = new MemoryMemberRepository();
      MemberService memberService = new MemberService(repository);



    @BeforeEach
    void beforeEach(){


        repository.clearStore();
    }


    @Test
    void join(){
        Member member1 = new Member();
        member1.setName("홍길동");
        Member member2 = new Member();
        member2.setName("신익수");

        Long joinedId = memberService.join(member2);
        Member findedMember = memberService.getMember(joinedId);

        assertThat(findedMember.getId()).isEqualTo(joinedId);
        System.out.println(findedMember.getName());
     }

    @Test
    void 중복발생가입(){
        //숙제
    }





     @Test
     void getAllMembers(){
        Member member1 = new Member();
        member1.setName("최민정");
        Member member2 = new Member();
        member2.setName("김아랑");

        memberService.join(member1);
        memberService.join(member2);

        List<Member> res = memberService.getAllMembers();
        assertThat(res.size()).isEqualTo(2);

     }

     @Test
    void getMember(){
         Member member1 = new Member();
         member1.setName("이유빈");

         memberService.join(member1);
         Member res = memberService.getMember(member1.getId());

         System.out.println(res.getName());

         assertThat(res.getName()).isEqualTo(member1.getName());
     }


}
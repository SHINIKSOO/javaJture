package com.javajocchyo.study.service;

import com.javajocchyo.study.domain.Member;
import com.javajocchyo.study.repository.JdbcMemberRepository;
import com.javajocchyo.study.repository.MemberRepository;
import com.javajocchyo.study.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

      @Autowired MemberService memberService;



    @BeforeEach
    void beforeEach(){

        //repository = new JdbcMemberRepository();
        //memberService  = new MemberService(repository);

    }

    @AfterEach
    void afterEach(){
       // repository.clearStore();
    }

    @Test
    void TestDI(){
        System.out.println(">>>>>>memberservice ="+ memberService);
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
        Member member1 = new Member();
        member1.setName("신익수2");
        Member member2 = new Member();
        member2.setName("신익수2");

        Long joinedId = memberService.join(member1);
        assertThatThrownBy( ()-> {memberService.join(member2);})
                .isInstanceOf(Exception.class).hasMessageContaining("중복된 이름이 있습니다");


       // Member findedMember = memberService.checkDuplicationName(joinedId);
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

     @Test
     void testString(){
        String str1= new String("abcde");
        String str2 = str1;
        String str3= "abcde"; //스트링 리터럴
        String str4="abcde"; // 스트링 리터럴

        assertThat(str1).isSameAs(str2);
      //  assertThat(str3).isEqualTo(str4);

        //Stringbuilder가 좋당~ !
     }

}
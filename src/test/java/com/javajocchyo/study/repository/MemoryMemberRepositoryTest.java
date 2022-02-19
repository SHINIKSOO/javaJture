package com.javajocchyo.study.repository;

import com.javajocchyo.study.domain.Member;
import com.javajocchyo.study.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemoryMemberRepositoryTest {


   //MemoryMemberRepository repository = new MemoryMemberRepository();
    @Autowired
    MemoryMemberRepository repository;

  //@AfterEach void afterEach(){ memberRepositoty.clearsotrt()};

    @BeforeEach
    void beforeEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        //Given

        Member member = new Member();
        member.setName("신익수");

        Member member2 = new Member();
        member.setName("zzz");
        //When
        repository.save(member);
        repository.save(member2);

        Optional<Member> optionalMember = repository.findById(member.getId());
        Member savedMember = optionalMember.get();

        assertThat(savedMember).isEqualTo(member);
        System.out.println(member.getName());


    }

    //TestCode
    @Test
    void findByName(){
        Member member = new Member();
        member.setName("신익수");
        repository.save(member);
        Optional<Member> optionalMember  = repository.findByName(member.getName());
        Member findedMember = optionalMember.get();

        assertThat(findedMember).isEqualTo(member);



        System.out.println( member.getName() );


    }


    @Test
    void findAll(){



        Member member1 = new Member();
        Member member2 = new Member();
       Member member3 = new Member();

        member1.setName("신익수");
        repository.save(member1);


       // save();
        List<Member> res = repository.findAll();
     //   assertThat(res.get(0)).isEqualTo(member1);

   //     System.out.println(res.get(0));
     //   System.out.println(res.get(1));
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);







    }



}
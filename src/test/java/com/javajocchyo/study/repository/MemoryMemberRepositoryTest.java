package com.javajocchyo.study.repository;

import com.javajocchyo.study.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {


    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        //Given
        Member member = new Member();
        member.setName("신익수");
        //When
        repository.save(member);

        Optional<Member> optionalMember = repository.findById(member.getId());
        Member savedMember = optionalMember.get();

        assertThat(savedMember).isEqualTo(member);


        //Member member2 = repository.findById2(1L);


        //Then
     //   assertThat(savedMember.getId()).isEqualTo(1);
      //  assertThat(savedMember).isEqualTo(member);  //==비교
    }


}
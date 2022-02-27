package com.javajocchyo.study.service;


import com.javajocchyo.study.domain.Member;


import com.javajocchyo.study.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    //스프링빈주입
    //1. 생성자주입 빈생성시점주입후,변경불가
    //2. 세터주입 - public이기에 실행중 호출 가능
    //3. 필드주입 - 스프링에서만 주입가능(테스트코드에서는사용가능)

    /*SOLID 원칙?
    SRP  단일책임원칙
    OCP  개방-폐쇄법칙
    LSP  리스코프 치환 원칙  --> 상위타입은 하위타입을 담을 수 있다.
    ISP  인터페이스분리우너칙
    DIP 의존관계역전원칙


     */



    private MemberRepository repository;
    @Autowired //생성자가 1개일때는 autowired 생략가능
    public MemberService(MemberRepository repository){
        this.repository = repository;
        System.out.println(">>> repository =" + repository);
    }


    public Long join(Member member){
        try {
            checkDuplicationName(member);
            repository.save(member);
            return member.getId();
        }catch (IllegalStateException e){
            //return 0L;
            throw e;
        }

    }

    private void checkDuplicationName (Member member){
        Optional<Member> res = repository.findByName(member.getName());
        if(res.isPresent()){
            throw new IllegalStateException("중복된 이름이 있습니다");
        }
    }


    public List<Member> getAllMembers(){
        return repository.findAll();
    }

    public Member getMember(Long memberId){
        Optional<Member> res = repository.findById(memberId);
        return res.orElse(null);
    }


}

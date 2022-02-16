package com.javajocchyo.study.service;


import com.javajocchyo.study.domain.Member;


import com.javajocchyo.study.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    //@Autowired
    private final MemberRepository repository;

    public MemberService(MemberRepository repository){
        this.repository = repository;
    }


    public Long join(Member member){
        repository.save(member);
        return member.getId();
    }


    public List<Member> getAllMembers(){
        return repository.findAll();
    }

    public Member getMember(Long memberId){
        Optional<Member> res = repository.findById(memberId);
        return res.orElse(null);
    }
}

package com.javajocchyo.study.repository;



import com.javajocchyo.study.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override //재정의메소드라는 명시적 표현 WHY? 누군가의 수정을 막기위함
    public Member save(Member member) {

        member.setId(++sequence);

        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = store.get(id);

        return Optional.ofNullable(member); //Optional
    }




// TEST 코드
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  //stream
                .filter(member -> member.getName().equals(name)) //Lambda
                .findAny();

    }
// TEST 코드
    @Override
    public List<Member> findAll() {
       return new ArrayList<>(store.values());

    }

    @Override
    public void clearStore() {
        store.clear();
    }


}

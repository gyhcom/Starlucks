package com.starlucks.member.infrastructure.persistence;

import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.MemberRepository;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMemberAddRepository implements MemberRepository {

    private final ConcurrentHashMap<Long, Member> map = new ConcurrentHashMap<>();

    @Override
    public Member save(Member member) {
        map.put(member.getId(), member);
        return member;
    }
}

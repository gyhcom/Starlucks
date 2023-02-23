package com.starlucks.member.infrastructure.persistence.inmemory;

import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.MemberRepository;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryMemberAddRepository implements MemberRepository {

    private final ConcurrentHashMap<Long, Member> map = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Member save(Member member) {

        return map.put(idGenerator.incrementAndGet(), member);
    }
}

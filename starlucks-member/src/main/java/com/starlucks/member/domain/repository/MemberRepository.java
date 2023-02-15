package com.starlucks.member.domain.repository;

import com.starlucks.member.domain.entity.Member;

public interface MemberRepository {

    Member save(Member member);
}

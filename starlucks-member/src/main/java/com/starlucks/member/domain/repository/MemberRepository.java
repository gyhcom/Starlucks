package com.starlucks.member.domain.repository;

import com.starlucks.member.domain.entity.Member;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Member findByEmail(String email);

    boolean existsByEmail(String email);
}

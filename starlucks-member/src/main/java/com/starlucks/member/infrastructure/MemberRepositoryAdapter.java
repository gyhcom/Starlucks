package com.starlucks.member.infrastructure;

import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.infrastructure.persistence.jpa.JpaMemberRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryAdapter implements MemberRepository {
    private final JpaMemberRepository jpaMemberRepository;

    public MemberRepositoryAdapter(JpaMemberRepository jpaMemberRepository) {
        this.jpaMemberRepository = jpaMemberRepository;
    }

    @Override
    public Member save(Member member) {
        return jpaMemberRepository.save(member);
    }

    @Override
    public Member findByEmail(String email) {
        return this.jpaMemberRepository.findByEmail(email)
            .orElseThrow(()-> new NullPointerException("가입되지 않은 회원입니다."));
    }
}

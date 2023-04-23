package com.starlucks.member.infrastructure;

import com.starlucks.common.auth.AuthMember;
import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.TokenRepository;
import com.starlucks.member.infrastructure.persistence.redis.RedisMemberRepository;

public class TokenRepositoryAdapter implements TokenRepository {

    private final RedisMemberRepository repository;

    public TokenRepositoryAdapter(RedisMemberRepository tokenRepository) {
        this.repository = tokenRepository;
    }

    @Override
    public void save(AuthMember authMember) {
        this.repository.save(authMember);
    }

    @Override
    public void remove(String token) {
        this.repository.remove(token);
    }
}

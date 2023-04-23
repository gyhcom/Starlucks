package com.starlucks.member.infrastructure;

import com.starlucks.member.domain.MemberToken;
import com.starlucks.member.domain.repository.TokenRepository;
import java.util.UUID;

public class MemberTokenGenerator implements MemberToken {

    private TokenRepository tokenRepository;

    public MemberTokenGenerator(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}

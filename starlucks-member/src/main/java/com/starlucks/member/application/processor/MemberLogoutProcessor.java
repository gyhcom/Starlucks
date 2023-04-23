package com.starlucks.member.application.processor;

import com.starlucks.member.domain.repository.TokenRepository;

public class MemberLogoutProcessor {

    private final TokenRepository tokenRepository;

    public MemberLogoutProcessor(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void execute(String token) {
        tokenRepository.remove(token);
    }
}

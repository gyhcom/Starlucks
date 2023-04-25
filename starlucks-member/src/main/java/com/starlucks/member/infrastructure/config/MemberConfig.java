package com.starlucks.member.infrastructure.config;

import com.starlucks.member.application.processor.MemberAddProcessor;
import com.starlucks.member.application.processor.MemberLoginProcessor;
import com.starlucks.member.application.processor.MemberLogoutProcessor;
import com.starlucks.member.domain.MemberToken;
import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.domain.repository.TokenRepository;
import com.starlucks.member.infrastructure.MemberTokenGenerator;
import com.starlucks.member.infrastructure.membersecurity.MemberPassWordEncoder;
import com.starlucks.member.infrastructure.properties.TokenProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MemberConfig {

    @Bean
    public MemberAddProcessor memberAddProcessor(
        MemberRepository memberRepository) {
        return new MemberAddProcessor(memberRepository, new MemberPassWordEncoder(memberEncoder()));
    }

    @Bean
    public MemberLoginProcessor memberLoginProcessor(
        MemberRepository memberRepository,
        MemberToken memberToken,
        TokenRepository tokenRepository,
        TokenProperties tokenProperties
    ) {
        return new MemberLoginProcessor(
            memberRepository,
            memberToken,
            tokenRepository,
            new MemberPassWordEncoder(memberEncoder()),
            tokenProperties.getTokenExpirationSec()
        );
    }

    @Bean
    public MemberLogoutProcessor memberLogoutProcessor(TokenRepository tokenRepository) {
        return new MemberLogoutProcessor(tokenRepository);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PasswordEncoder memberEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MemberToken memberToken(
        TokenRepository tokenRepository
    ) {
        return new MemberTokenGenerator(tokenRepository);
    }
}

package com.starlucks.member.infrastructure.config;

import com.starlucks.member.application.processor.MemberAddProcessor;
import com.starlucks.member.application.processor.MemberLoginProcessor;
import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.infrastructure.membersecurity.MemberPassWordEncoder;
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
        MemberRepository memberRepository
    ) {
        return new MemberLoginProcessor(
            memberRepository,
            new MemberPassWordEncoder(memberEncoder())
        );
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PasswordEncoder memberEncoder() {
        return new BCryptPasswordEncoder();
    }
}

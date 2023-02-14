package com.starlucks.member.infrastructure.config;

import com.starlucks.member.application.processor.MemberAddProcessor;
import com.starlucks.member.domain.IdGenerator;
import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.infrastructure.generator.MemberIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MemberConfig {

    @Bean
    public MemberAddProcessor memberAddProcessor(MemberRepository memberRepository) {
        return new MemberAddProcessor(memberRepository, new MemberIdGenerator());
    }
}

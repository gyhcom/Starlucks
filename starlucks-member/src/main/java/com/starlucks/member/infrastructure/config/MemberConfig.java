package com.starlucks.member.infrastructure.config;

import com.starlucks.member.application.processor.MemberAddProcessor;
import com.starlucks.member.domain.IdGenerator;
import com.starlucks.member.domain.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public MemberAddProcessor memberAddProcessor(MemberRepository memberRepository) {
        return new MemberAddProcessor(memberRepository);
    }
}

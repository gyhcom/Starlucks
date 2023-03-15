package com.starlucks.member.infrastructure.config;

import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.infrastructure.MemberRepositoryAdapter;
import com.starlucks.member.infrastructure.persistence.jpa.JpaMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MemberRepositoryConfig {
    @Bean
    public MemberRepository memberRepository(JpaMemberRepository jpaMemberRepository) {
        return new MemberRepositoryAdapter(jpaMemberRepository);
    }
}
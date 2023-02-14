package com.starlucks.member.infrastructure.config;

import com.starlucks.member.infrastructure.persistence.InMemoryMemberAddRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MemberRepositoryConfig {
    @Bean
    public InMemoryMemberAddRepository inMemoryMemberAddRepository() {
        return new InMemoryMemberAddRepository();
    }
}
package com.starlucks.member.infrastructure.config;

import com.starlucks.member.domain.repository.TokenRepository;
import com.starlucks.member.infrastructure.TokenRepositoryAdapter;
import com.starlucks.member.infrastructure.persistence.redis.RedisMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenRepositoryConfig {

    @Bean
    public TokenRepository tokenRepository(RedisMemberRepository redisMemberRepository) {
        return new TokenRepositoryAdapter(redisMemberRepository);
    }
}

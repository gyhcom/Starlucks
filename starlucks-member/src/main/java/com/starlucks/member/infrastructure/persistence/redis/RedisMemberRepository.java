package com.starlucks.member.infrastructure.persistence.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starlucks.common.auth.AuthMember;
import com.starlucks.member.infrastructure.properties.TokenProperties;
import java.time.Duration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisMemberRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    private final TokenProperties tokenProperties;

    public RedisMemberRepository(
        RedisTemplate<String, Object> redisTemplate,
        ObjectMapper objectMapper,
        TokenProperties tokenProperties
    ) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
        this.tokenProperties = tokenProperties;
    }

    public void save(AuthMember authMember) {
        redisTemplate.opsForValue().set(
            authMember.getAuthId(),
            authMember,
            Duration.ofSeconds(tokenProperties.getTokenExpireSec()));
    }

    public void remove(String token) {
        redisTemplate.delete(token);
    }
}

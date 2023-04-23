package com.starlucks.member.infrastructure.persistence.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starlucks.common.auth.AuthMember;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisMemberRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisMemberRepository(
        RedisTemplate<String, Object> redisTemplate,
        ObjectMapper objectMapper
    ) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public void save(AuthMember authMember) {
        redisTemplate.opsForValue().set(
            authMember.getAuthId(),
            authMember);
    }

    public void remove(String token) {
        redisTemplate.delete(token);
    }
}

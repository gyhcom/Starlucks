package com.starlucks.member.infrastructure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.redis.token")
public final class TokenProperties {
    private Long tokenExpireSec;

    public Long getTokenExpireSec() {
        return tokenExpireSec;
    }

    public void setTokenExpireSec(Long tokenExpireSec) {
        this.tokenExpireSec = tokenExpireSec;
    }
}

package com.starlucks.common.auth;

import java.io.Serializable;
import java.time.LocalDate;

public class AuthMember implements Serializable {

    private long id;

    private String authId;

    private String email;

    private LocalDate expireAt;

    protected  AuthMember() {

    }

    private AuthMember(Builder builder) {
        this.id = builder.id;
        this.authId = builder.authId;
        this.email = builder.email;
        this.expireAt = builder.expireAt;
    }

    public long getId() {
        return id;
    }

    public String getAuthId() {
        return authId;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getExpireAt() {
        return expireAt;
    }


    public static class Builder {

        public Builder(long id) {
            this.id = id;
        }

        public Builder setAuthId(String authId) {
            this.authId = authId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setExpireAt(LocalDate expireAt) {
            this.expireAt = expireAt;
            return this;
        }


        public AuthMember build() {
            return new AuthMember(this);
        }

        private long id;

        private String authId;

        private String email;

        private LocalDate expireAt;
    }
}

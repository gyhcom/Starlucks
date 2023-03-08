package com.starlucks.member.application.command;

import com.starlucks.member.domain.entity.Member;

public class MemberAddCommand {
    private String nickname;
    private String email;
    private String password;

    public MemberAddCommand(
        String nickname,
        String email,
        String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public Member toEntity(String password) {
        return new Member(
            this.email,
            this.nickname,
            password
        );
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

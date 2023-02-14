package com.starlucks.member.application.command;

import com.starlucks.member.domain.entity.Member;

public class MemberAddCommand {
    private String nickname;
    private String email;
    private String password;
    private String phoneNumber;


    public MemberAddCommand(
        String nickname,
        String email,
        String password,
        String phoneNumber) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

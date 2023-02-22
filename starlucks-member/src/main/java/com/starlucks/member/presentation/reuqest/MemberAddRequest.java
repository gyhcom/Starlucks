package com.starlucks.member.presentation.reuqest;

import com.starlucks.member.application.command.MemberAddCommand;


public class MemberAddRequest {
    private String nickname;
    private String email;
    private String password;


    public MemberAddRequest(String email, String password, String nickname) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public MemberAddRequest() {

    }

    public MemberAddCommand toCommand() {
        return new MemberAddCommand(nickname, email, password);
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

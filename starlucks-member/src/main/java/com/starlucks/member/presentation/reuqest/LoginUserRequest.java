package com.starlucks.member.presentation.reuqest;

import com.starlucks.member.application.command.MemberLoginCommand;

public class LoginUserRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public MemberLoginCommand toCommand() {
        return new MemberLoginCommand(email, password);
    }
}

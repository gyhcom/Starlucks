package com.starlucks.member.presentation.reuqest;

import com.starlucks.member.application.command.MemberLoginCommand;

public class MemberEmailRequest {

    private String email;

    protected MemberEmailRequest() {
    }

    public MemberEmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

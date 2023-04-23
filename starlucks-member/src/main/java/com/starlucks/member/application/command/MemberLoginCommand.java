package com.starlucks.member.application.command;

public class MemberLoginCommand {

    private String email;
    private String password;


    public MemberLoginCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

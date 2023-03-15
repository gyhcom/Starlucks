package com.starlucks.member.presentation.reponse;

import com.starlucks.member.application.result.MemberResult;

public final class MemberResponse {

    private Long id;
    private String email;


    public MemberResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public static MemberResponse form(MemberResult memberResult) {
        return new MemberResponse(memberResult.getId(), memberResult.getEmail());
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

package com.starlucks.member.application.result;

import com.starlucks.member.domain.entity.Member;

public final class MemberResult {
    private Long id;

    private String email;


    public MemberResult(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public static MemberResult result(Member member) {
        return new MemberResult(member.getId(), member.getEmail());
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}

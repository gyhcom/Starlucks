package com.starlucks.member.domain.entity;

public class Member {

    private Long id;
    private String nickname;
    private String email;
    private String password;

    public Member() {

    }


    public static Member from(Long id, String nickname, String email, String password) {
        return new Member();
    }

    public Long getId() {
        return id;
    }

}

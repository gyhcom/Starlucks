package com.starlucks.member.presentation;

import com.starlucks.member.application.fasade.MemberManager;
import com.starlucks.member.presentation.reuqest.MemberAddRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public final class MemberController {

    private final MemberManager memberManager;

    public MemberController(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @PostMapping(value = "/signUp", name = "회원 가입")
    public void signUp(@RequestBody MemberAddRequest request) {
        memberManager.memberCreate(request.toCommand());
    }
}

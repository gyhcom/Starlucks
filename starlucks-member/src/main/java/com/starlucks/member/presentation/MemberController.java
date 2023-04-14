package com.starlucks.member.presentation;

import com.starlucks.common.response.CommonApiResponse;
import com.starlucks.member.application.fasade.MemberManager;
import com.starlucks.member.presentation.reponse.MemberResponse;
import com.starlucks.member.presentation.reuqest.LoginUserRequest;
import com.starlucks.member.presentation.reuqest.MemberAddRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@MemberRestController
public class MemberController {

    private final MemberManager memberManager;

    public MemberController(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @PostMapping(value = "/signUp", name = "회원 가입")
    public CommonApiResponse<MemberResponse> signUp(@RequestBody MemberAddRequest request) {
        var member = memberManager.memberCreate(request.toCommand());
        return CommonApiResponse.success(MemberResponse.form(member));
    }

    @PostMapping(value = "/login", name = "회원 로그인")
    public CommonApiResponse<String> login(@RequestBody LoginUserRequest request) {
        var member = memberManager.login(request.toCommand());
        return CommonApiResponse.success(member);
    }

    @PostMapping(value = "/logout", name = "회원 로그아웃")
    public CommonApiResponse<String> logout(@RequestHeader String authorization) {
        memberManager.logout(authorization.replace("Bearer ", ""));
        return CommonApiResponse.success("ok");
    }
}

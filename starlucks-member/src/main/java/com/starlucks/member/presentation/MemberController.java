package com.starlucks.member.presentation;

import com.starlucks.common.response.CommonApiResponse;
import com.starlucks.member.application.fasade.MemberManager;
import com.starlucks.member.presentation.reponse.MemberResponse;
import com.starlucks.member.presentation.reuqest.MemberAddRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}

package com.starlucks.member.application.processor;

import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.application.result.MemberResult;
import com.starlucks.member.domain.IdGenerator;
import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.MemberRepository;

public final class MemberAddProcessor {

    private final MemberRepository memberRepository;

    public MemberAddProcessor(
        MemberRepository memberRepository
    ) {
        this.memberRepository = memberRepository;
    }

    public MemberResult execute(MemberAddCommand command) {
        String pass = command.getPassword();
        var member = memberRepository.save(command.toEntity(pass));

        return MemberResult.result(member);
    }
}

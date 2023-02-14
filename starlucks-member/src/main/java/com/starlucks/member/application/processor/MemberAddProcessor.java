package com.starlucks.member.application.processor;

import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.domain.IdGenerator;
import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.infrastructure.generator.MemberIdGenerator;

public final class MemberAddProcessor {

    private final MemberRepository memberRepository;
    private final MemberIdGenerator memberIdGenerator;

    public MemberAddProcessor(
        MemberRepository memberRepository,
        MemberIdGenerator memberIdGenerator
    ) {
        this.memberRepository = memberRepository;
        this.memberIdGenerator = memberIdGenerator;
    }

    public void execute(MemberAddCommand command) {
        memberRepository.save(
            Member.from(memberIdGenerator.generate(),
                command.getNickname(),
                command.getEmail(),
                command.getPassword())
        );
    }
}

package com.starlucks.member.application.processor;

import com.starlucks.common.auth.EncryptionPassword;
import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.application.result.MemberResult;
import com.starlucks.member.domain.repository.MemberRepository;

public final class MemberAddProcessor {

    private final MemberRepository memberRepository;
    private static EncryptionPassword passwordEncoder;

    public MemberAddProcessor(
        MemberRepository memberRepository,
        EncryptionPassword passwordEncoder
    ) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberResult execute(MemberAddCommand command) {
        String encodePassword = passwordEncoder.encrypt(command.getPassword());
        var member = memberRepository.save(command.toEntity(encodePassword));
        return MemberResult.result(member);
    }
}

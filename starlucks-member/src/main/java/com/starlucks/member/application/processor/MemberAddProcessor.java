package com.starlucks.member.application.processor;

import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.application.result.MemberResult;
import com.starlucks.member.domain.IdGenerator;
import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public final class MemberAddProcessor {

    private final MemberRepository memberRepository;
    private static PasswordEncoder passwordEncoder;

    public MemberAddProcessor(
        MemberRepository memberRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberResult execute(MemberAddCommand command) {
        String encodePassword = passwordEncoder.encode(command.getPassword());
        var member = memberRepository.save(command.toEntity(encodePassword));
        return MemberResult.result(member);
    }
}

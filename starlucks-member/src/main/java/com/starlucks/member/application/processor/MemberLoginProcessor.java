package com.starlucks.member.application.processor;

import com.starlucks.common.auth.EncryptionPassword;
import com.starlucks.member.application.command.MemberLoginCommand;
import com.starlucks.member.domain.repository.MemberRepository;

public class MemberLoginProcessor {

    private final MemberRepository memberRepository;
    private final EncryptionPassword encryptionPassword;

    public MemberLoginProcessor(
        MemberRepository memberRepository,
        EncryptionPassword encryptionPassword) {
        this.memberRepository = memberRepository;
        this.encryptionPassword = encryptionPassword;
    }

    public String excute(MemberLoginCommand command) {
        var member = memberRepository.findByEmail(command.getEmail());

        if (member == null) {
            throw new RuntimeException();
        }
        var token = "Token";
        return token;
    }
}

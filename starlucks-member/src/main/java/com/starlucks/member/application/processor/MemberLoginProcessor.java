package com.starlucks.member.application.processor;

import com.starlucks.common.auth.AuthMember;
import com.starlucks.common.auth.EncryptionPassword;
import com.starlucks.member.application.command.MemberLoginCommand;
import com.starlucks.member.domain.MemberToken;
import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.domain.repository.TokenRepository;
import com.starlucks.member.infrastructure.membersecurity.MemberPassWordEncoder;
import java.time.LocalDate;

public class MemberLoginProcessor {

    private final MemberRepository memberRepository;
    private final MemberToken memberToken;
    private final TokenRepository tokenRepository;
    private final EncryptionPassword encryptionPassword;
    private Member member;

    public MemberLoginProcessor(
        MemberRepository memberRepository,
        MemberToken memberToken,
        TokenRepository tokenRepository,
        EncryptionPassword encryptionPassword
    ) {

        this.memberRepository = memberRepository;
        this.memberToken = memberToken;
        this.tokenRepository = tokenRepository;
        this.encryptionPassword = encryptionPassword;
    }

    public String excute(MemberLoginCommand command) {
        var member = memberRepository.findByEmail(command.getEmail());

        if (member == null) {
            throw new NullPointerException("잘못된 회원입니다.");
        }

        var token = memberToken.generate();

        //토큰 저장 구현
        tokenRepository.save(
            new AuthMember.Builder(member.getId())
                .setAuthId(token)
                .setEmail(member.getEmail())
                .setExpireAt(LocalDate.now())
                .build()
        );

        return token;
    }
}

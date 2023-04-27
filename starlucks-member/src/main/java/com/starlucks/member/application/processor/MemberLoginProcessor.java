package com.starlucks.member.application.processor;

import com.starlucks.common.auth.AuthMember;
import com.starlucks.common.auth.EncryptionPassword;
import com.starlucks.common.exception.ErrorCode;
import com.starlucks.member.application.command.MemberLoginCommand;
import com.starlucks.member.domain.MemberToken;
import com.starlucks.member.domain.entity.Member;
import com.starlucks.member.domain.exception.MemberException;
import com.starlucks.member.domain.exception.MemberPasswordNotException;
import com.starlucks.member.domain.repository.MemberRepository;
import com.starlucks.member.domain.repository.TokenRepository;
import java.time.LocalDateTime;

public class MemberLoginProcessor {

    private final MemberRepository memberRepository;
    private final MemberToken memberToken;
    private final TokenRepository tokenRepository;
    private final EncryptionPassword encryptionPassword;

    private final Long tokenExpireSec;

    public MemberLoginProcessor(
        MemberRepository memberRepository,
        MemberToken memberToken,
        TokenRepository tokenRepository,
        EncryptionPassword encryptionPassword,
        Long tokenExpireSec

    ) {

        this.memberRepository = memberRepository;
        this.memberToken = memberToken;
        this.tokenRepository = tokenRepository;
        this.encryptionPassword = encryptionPassword;
        this.tokenExpireSec = tokenExpireSec;
    }

    public String execute(MemberLoginCommand command) {
        var member = memberRepository.findByEmail(command.getEmail());

        if (member == null) {
            throw new MemberException(ErrorCode.INVALID_USER);
        }

        if (!passwordCheck(command, member)) {
            throw new MemberPasswordNotException();
        }
        var token = memberToken.generate();

        //토큰 저장 구현
        tokenRepository.save(
            new AuthMember.Builder(member.getId())
                .setAuthId(token)
                .setEmail(member.getEmail())
                .setExpireAt(LocalDateTime.now().plusSeconds(tokenExpireSec))
                .build()
        );

        return token;
    }

    private boolean passwordCheck(MemberLoginCommand command, Member member) {
        return encryptionPassword.matches(command.getPassword(), member.getPassword());
    }
}

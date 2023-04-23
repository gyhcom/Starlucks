package com.starlucks.member.application.fasade;

import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.application.command.MemberLoginCommand;
import com.starlucks.member.application.processor.MemberAddProcessor;
import com.starlucks.member.application.processor.MemberLoginProcessor;
import com.starlucks.member.application.processor.MemberLogoutProcessor;
import com.starlucks.member.application.result.MemberResult;
import com.starlucks.member.domain.exception.MemberEmailException;
import com.starlucks.member.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberManager {

    private final MemberAddProcessor memberAddProcessor;

    private final MemberLoginProcessor memberLoginProcessor;

    private final MemberLogoutProcessor memberLogoutProcessor;

    private final MemberRepository memberRepository;

    public MemberManager(MemberAddProcessor memberAddProcessor,
        MemberLoginProcessor memberLoginProcessor,
        MemberLogoutProcessor memberLogoutProcessor,
        MemberRepository memberRepository
    ) {

        this.memberAddProcessor = memberAddProcessor;
        this.memberLoginProcessor = memberLoginProcessor;
        this.memberLogoutProcessor = memberLogoutProcessor;
        this.memberRepository = memberRepository;
    }

    public MemberResult memberCreate(MemberAddCommand command) {
        return memberAddProcessor.execute(command);
    }

    public String login(MemberLoginCommand toCommand) {
        return memberLoginProcessor.execute(toCommand);
    }

    public void logout(String token) {
        memberLogoutProcessor.execute(token);
    }

    public void checkEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new MemberEmailException();
        }
    }
}

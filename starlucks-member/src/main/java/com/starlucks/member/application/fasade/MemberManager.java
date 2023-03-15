package com.starlucks.member.application.fasade;

import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.application.processor.MemberAddProcessor;
import com.starlucks.member.application.result.MemberResult;
import org.springframework.stereotype.Service;

@Service
public class MemberManager {

    private final MemberAddProcessor memberAddProcessor;

    public MemberManager(MemberAddProcessor memberAddProcessor) {
        this.memberAddProcessor = memberAddProcessor;
    }

    public MemberResult memberCreate(MemberAddCommand command) {
        return memberAddProcessor.execute(command);
    }

}

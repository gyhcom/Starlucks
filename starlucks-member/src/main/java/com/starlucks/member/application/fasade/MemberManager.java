package com.starlucks.member.application.fasade;

import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.application.command.MemberLoginCommand;
import com.starlucks.member.application.processor.MemberAddProcessor;
import com.starlucks.member.application.processor.MemberLoginProcessor;
import com.starlucks.member.application.result.MemberResult;
import org.springframework.stereotype.Service;

@Service
public class MemberManager {

    private final MemberAddProcessor memberAddProcessor;

    private final MemberLoginProcessor memberLoginProcessor;

    public MemberManager(MemberAddProcessor memberAddProcessor,
        MemberLoginProcessor memberLoginProcessor) {
        this.memberAddProcessor = memberAddProcessor;
        this.memberLoginProcessor = memberLoginProcessor;
    }

    public MemberResult memberCreate(MemberAddCommand command) {
        return memberAddProcessor.execute(command);
    }

    public String login(MemberLoginCommand toCommand) {
        return memberLoginProcessor.excute(toCommand);
    }
}

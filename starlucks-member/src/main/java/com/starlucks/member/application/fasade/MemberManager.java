package com.starlucks.member.application.fasade;

import com.starlucks.member.application.command.MemberAddCommand;
import com.starlucks.member.application.processor.MemberAddProcessor;
import org.springframework.stereotype.Service;

@Service
public class MemberManager {

    private final MemberAddProcessor memberAddProcessor;

    public MemberManager(MemberAddProcessor memberAddProcessor) {
        this.memberAddProcessor = memberAddProcessor;
    }

    public void memberCreate(MemberAddCommand command) {
        memberAddProcessor.execute(command);
    }

}

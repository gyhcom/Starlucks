package com.starlucks.member.domain.exception;

import com.starlucks.common.exception.ErrorCode;

public class MemberEmailException extends RuntimeException {
    public MemberEmailException() {
        super(ErrorCode.DUPLICATED_EMAIL.getMessage());
    }
}

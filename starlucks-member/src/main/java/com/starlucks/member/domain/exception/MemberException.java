package com.starlucks.member.domain.exception;

import com.starlucks.common.exception.ErrorCode;

public class MemberException extends RuntimeException {

    public MemberException(ErrorCode invalidUser) {
        super(ErrorCode.INVALID_USER.getMessage());
    }
}

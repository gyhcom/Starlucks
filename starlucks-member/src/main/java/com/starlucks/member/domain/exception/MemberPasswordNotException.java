package com.starlucks.member.domain.exception;

import com.starlucks.common.exception.ErrorCode;

public class MemberPasswordNotException extends RuntimeException {

    public MemberPasswordNotException() {
        super(ErrorCode.PASSWORD_NOT_MATCHED.getMessage());
    }
}

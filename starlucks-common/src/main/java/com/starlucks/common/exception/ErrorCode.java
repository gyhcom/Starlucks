package com.starlucks.common.exception;

public enum ErrorCode {
    DUPLICATED_EMAIL("사용중인 이메일입니다.");
    private final  String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

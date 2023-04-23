package com.starlucks.common.auth;

public interface EncryptionPassword {

    String encrypt(String text);

    boolean matches(String memberPass, String encryptPass);
}

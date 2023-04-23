package com.starlucks.member.infrastructure.membersecurity;

import com.starlucks.common.auth.EncryptionPassword;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MemberPassWordEncoder implements EncryptionPassword {

    private final PasswordEncoder encoder;

    public MemberPassWordEncoder(PasswordEncoder passwordEncoder) {
        this.encoder = passwordEncoder;
    }

    @Override
    public String encrypt(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String memberPass, String encryptPass) {
        return encoder.matches(memberPass, encryptPass);
    }
}
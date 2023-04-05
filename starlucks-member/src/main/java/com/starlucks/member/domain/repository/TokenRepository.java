package com.starlucks.member.domain.repository;

import com.starlucks.common.auth.AuthMember;
import com.starlucks.member.domain.entity.Member;
import org.springframework.stereotype.Repository;

public interface TokenRepository {

    void save(AuthMember authMember);

    void remove();

}

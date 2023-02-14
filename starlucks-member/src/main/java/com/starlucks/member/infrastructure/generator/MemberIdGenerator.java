package com.starlucks.member.infrastructure.generator;

import com.starlucks.member.domain.IdGenerator;
import java.util.concurrent.atomic.AtomicLong;

public class MemberIdGenerator implements IdGenerator {
    private final AtomicLong inc = new AtomicLong(1L);

    @Override
    public long generate() {
        return inc.getAndIncrement();
    }
}

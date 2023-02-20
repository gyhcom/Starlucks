package com.starlucks.payment.infrastructure.generator;

import com.starlucks.payment.domain.IdGenerator;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentIdGenerator implements IdGenerator {

    private final AtomicLong inc = new AtomicLong(1L);

    @Override
    public long generate() {
        return inc.getAndIncrement();
    }
}

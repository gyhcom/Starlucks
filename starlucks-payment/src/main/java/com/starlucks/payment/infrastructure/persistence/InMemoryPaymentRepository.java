package com.starlucks.payment.infrastructure.persistence;

import com.starlucks.payment.domain.entity.Payment;
import com.starlucks.payment.domain.repository.PaymentRepository;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPaymentRepository implements PaymentRepository {

    private final ConcurrentHashMap<Long, Payment> map = new ConcurrentHashMap<>();

    @Override
    public Payment save(Payment payment) {
        map.put(payment.getId(), payment);
        return findById(payment.getId());
    }

    @Override
    public Payment findById(Long id) {
        return map.get(id);
    }
}

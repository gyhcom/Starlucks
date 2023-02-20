package com.starlucks.payment.domain.repository;

import com.starlucks.payment.domain.entity.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);

    Payment findById(Long id);
}

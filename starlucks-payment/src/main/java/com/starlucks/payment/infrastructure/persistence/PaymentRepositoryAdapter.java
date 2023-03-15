package com.starlucks.payment.infrastructure.persistence;

import com.starlucks.payment.domain.entity.Payment;
import com.starlucks.payment.domain.repository.PaymentRepository;
import java.util.Optional;

public final class PaymentRepositoryAdapter implements PaymentRepository {

    private final JpaPaymentRepository jpaPaymentRepository;

    public PaymentRepositoryAdapter(JpaPaymentRepository jpaPaymentRepository) {
        this.jpaPaymentRepository = jpaPaymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        return jpaPaymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return jpaPaymentRepository.findById(id);
    }
}

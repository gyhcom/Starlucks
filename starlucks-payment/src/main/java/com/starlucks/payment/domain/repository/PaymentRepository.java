package com.starlucks.payment.domain.repository;

import com.starlucks.payment.domain.entity.Payment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findById(Long id);
}

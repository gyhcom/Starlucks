package com.starlucks.payment.infrastructure.config;

import com.starlucks.payment.infrastructure.persistence.JpaPaymentRepository;
import com.starlucks.payment.infrastructure.persistence.PaymentRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public PaymentRepositoryAdapter paymentRepositoryAdapter(
        JpaPaymentRepository jpaPaymentRepository) {
        return new PaymentRepositoryAdapter(jpaPaymentRepository);
    }

}

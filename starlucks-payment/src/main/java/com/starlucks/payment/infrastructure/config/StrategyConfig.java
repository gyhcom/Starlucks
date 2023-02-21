package com.starlucks.payment.infrastructure.config;

import com.starlucks.payment.domain.repository.PaymentRepository;
import com.starlucks.payment.infrastructure.generator.PaymentIdGenerator;
import com.starlucks.payment.infrastructure.pay.TossPaymentStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyConfig {

    @Bean
    public TossPaymentStrategy tossPaymentStrategy(PaymentRepository paymentRepository) {
        return new TossPaymentStrategy(paymentRepository, new PaymentIdGenerator());
    }
}

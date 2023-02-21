package com.starlucks.payment.infrastructure.config;

import com.starlucks.payment.application.CompositionPayment;
import com.starlucks.payment.application.processor.PaymentProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentProcessor paymentProcessor(CompositionPayment paymentFactory) {
        return new PaymentProcessor(paymentFactory);
    }
}

package com.starlucks.payment.infrastructure.config;

import com.starlucks.payment.application.CompositionPayment;
import com.starlucks.payment.application.processor.RequestPaymentProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public RequestPaymentProcessor paymentProcessor(CompositionPayment paymentFactory) {
        return new RequestPaymentProcessor(paymentFactory);
    }
}

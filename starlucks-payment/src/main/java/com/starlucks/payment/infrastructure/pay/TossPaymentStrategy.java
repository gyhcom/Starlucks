package com.starlucks.payment.infrastructure.pay;

import com.starlucks.payment.application.PaymentStrategy;
import com.starlucks.payment.application.command.PaymentPayCommand;
import com.starlucks.payment.domain.entity.TossPayment;
import com.starlucks.payment.domain.repository.PaymentRepository;

public class TossPaymentStrategy implements PaymentStrategy {

    private final PaymentRepository paymentRepository;

    public TossPaymentStrategy(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public String getName() {
        return "toss";
    }

    @Override
    public void pay(PaymentPayCommand paymentPayCommand) {
        // fake
        var confirmResponse = TossConfirmResponse.of();

        paymentRepository.save(
            TossPayment.from(paymentPayCommand, confirmResponse)
        );
    }
}

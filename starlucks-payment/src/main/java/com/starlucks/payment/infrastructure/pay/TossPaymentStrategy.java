package com.starlucks.payment.infrastructure.pay;

import com.starlucks.payment.application.PaymentStrategy;
import com.starlucks.payment.application.command.PaymentPayCommand;
import com.starlucks.payment.domain.entity.TossPayment;
import com.starlucks.payment.domain.repository.PaymentRepository;
import com.starlucks.payment.infrastructure.generator.PaymentIdGenerator;

public class TossPaymentStrategy implements PaymentStrategy {

    private final PaymentRepository paymentRepository;
    private final PaymentIdGenerator paymentIdGenerator;

    public TossPaymentStrategy(PaymentRepository paymentRepository,
        PaymentIdGenerator paymentIdGenerator) {
        this.paymentRepository = paymentRepository;
        this.paymentIdGenerator = paymentIdGenerator;
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
            TossPayment.from(paymentIdGenerator.generate(), paymentPayCommand, confirmResponse)
        );
    }
}

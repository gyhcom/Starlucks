package com.starlucks.payment.application.processor;

import com.starlucks.payment.application.CompositionPayment;
import com.starlucks.payment.application.command.PaymentPayCommand;
import org.springframework.transaction.annotation.Transactional;

public class RequestPaymentProcessor {

    private final CompositionPayment compositionPayment;

    public RequestPaymentProcessor(CompositionPayment compositionPayment) {
        this.compositionPayment = compositionPayment;
    }

    @Transactional
    public void execute(PaymentPayCommand command) {
        var paymentStrategy = compositionPayment.getStrategyImpl(command.paymentTarget());

        paymentStrategy.pay(command);
    }
}

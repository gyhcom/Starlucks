package com.starlucks.payment.application.processor;

import com.starlucks.payment.application.CompositionPayment;
import com.starlucks.payment.application.command.PaymentPayCommand;
import org.jetbrains.annotations.NotNull;

public class PaymentProcessor {

    private final CompositionPayment compositionPayment;

    public PaymentProcessor(CompositionPayment compositionPayment) {
        this.compositionPayment = compositionPayment;
    }

    public void execute(PaymentPayCommand command) {
        var paymentStrategy = compositionPayment.getStrategyImpl(command.paymentTarget());
        paymentStrategy.pay(command);
    }
}

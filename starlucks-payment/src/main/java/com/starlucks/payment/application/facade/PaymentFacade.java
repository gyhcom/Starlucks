package com.starlucks.payment.application.facade;

import com.starlucks.payment.application.command.PaymentPayCommand;
import com.starlucks.payment.application.processor.PaymentProcessor;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {

    private final PaymentProcessor paymentProcessor;

    public PaymentFacade(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void pay(PaymentPayCommand paymentPayCommand) {
        // TODO 주문 금액과 결제 금액이 일치하는지

        paymentProcessor.execute(paymentPayCommand);

        // TODO Order 이벤트
    }
}

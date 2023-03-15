package com.starlucks.payment.application.facade;

import com.starlucks.payment.application.command.PaymentPayCommand;
import com.starlucks.payment.application.processor.RequestPaymentProcessor;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager {

    private final RequestPaymentProcessor paymentProcessor;

    public PaymentManager(RequestPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void pay(PaymentPayCommand paymentPayCommand) {
        // TODO 주문 금액과 결제 금액이 일치하는지

        paymentProcessor.execute(paymentPayCommand);

        // TODO Order 이벤트
    }
}

package com.starlucks.payment.application;

import com.starlucks.payment.application.command.PaymentPayCommand;

public interface PaymentStrategy {

    String getName();

    void pay(PaymentPayCommand paymentPayCommand);
}

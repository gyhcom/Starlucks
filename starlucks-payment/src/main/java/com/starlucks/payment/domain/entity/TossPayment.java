package com.starlucks.payment.domain.entity;

import com.starlucks.payment.application.command.PaymentPayCommand;
import com.starlucks.payment.infrastructure.pay.TossConfirmResponse;

public class TossPayment extends Payment {

    private final String tossId;

    public TossPayment(Long id, Long orderId, long amount, String tossId) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.tossId = tossId;
    }

    public static TossPayment from(Long id, PaymentPayCommand command,
        TossConfirmResponse response) {
        return new TossPayment(id, command.orderId(), command.amount(), response.tossId());
    }

}

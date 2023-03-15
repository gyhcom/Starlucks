package com.starlucks.payment.domain.entity;

import com.starlucks.payment.application.command.PaymentPayCommand;
import com.starlucks.payment.infrastructure.pay.TossConfirmResponse;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("toss")
public class TossPayment extends Payment {

    private String tossId;

    public TossPayment(Long orderId, long amount, String tossId) {
        this.orderId = orderId;
        this.amount = amount;
        this.tossId = tossId;
    }

    protected TossPayment() {
    }

    public static TossPayment from(PaymentPayCommand command,
        TossConfirmResponse response) {
        return new TossPayment(command.orderId(), command.amount(), response.tossId());
    }
}

package com.starlucks.payment.domain.entity;

public abstract class Payment {

    protected Long id;
    protected Long orderId;
    protected long amount;

    protected Payment() {

    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public long getAmount() {
        return amount;
    }
}

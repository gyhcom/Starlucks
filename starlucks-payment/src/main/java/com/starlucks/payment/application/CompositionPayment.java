package com.starlucks.payment.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CompositionPayment {

    private final Map<String, PaymentStrategy> map = new HashMap<>();

    public CompositionPayment(List<PaymentStrategy> pss) {
        if (pss.isEmpty()) {
            throw new RuntimeException();
        }
        pss.forEach((ps) -> map.put(ps.getName(), ps));
    }

    public PaymentStrategy getStrategyImpl(String paymentTarget) {
        var paymentStrategy = map.get(paymentTarget);

        if (null == paymentStrategy) {
            throw new RuntimeException();
        }
        return paymentStrategy;
    }
}

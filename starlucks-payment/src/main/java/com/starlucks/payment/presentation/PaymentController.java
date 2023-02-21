package com.starlucks.payment.presentation;

import com.starlucks.payment.application.facade.PaymentFacade;
import com.starlucks.payment.presentation.request.PaymentPayRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public final class PaymentController {

    private final PaymentFacade paymentFacade;

    public PaymentController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @PostMapping
    public void pay(@RequestBody final PaymentPayRequest paymentPayRequest) {
        paymentFacade.pay(paymentPayRequest.toCommand());
    }
}

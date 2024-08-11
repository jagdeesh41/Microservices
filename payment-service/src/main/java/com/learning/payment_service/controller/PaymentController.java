package com.learning.payment_service.controller;

import com.learning.payment_service.entity.Payment;
import com.learning.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment)
    {
        return paymentService.doPayment(payment);
    }
    @GetMapping("/history/{orderId}")
    public Payment paymentHistory(@PathVariable("orderId") int orderId)
    {
        return paymentService.getpaymentHistory(orderId);

    }



}

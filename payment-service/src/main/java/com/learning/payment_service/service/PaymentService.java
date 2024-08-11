package com.learning.payment_service.service;

import com.learning.payment_service.entity.Payment;
import com.learning.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {


    private final PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment)
    {

        payment.setTransactionId(String.valueOf(UUID.randomUUID()));
        payment.setPaymentStatus(paymentProcessing());
        return paymentRepository.save(payment);
    }
    private String paymentProcessing()
    {
        return new Random().nextBoolean()?"success":"denied";
    }


    public Payment getpaymentHistory(int orderId)
    {
        return paymentRepository.findByOrderId(orderId);
    }
}

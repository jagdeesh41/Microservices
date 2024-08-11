package com.learning.payment_service.repository;

import com.learning.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {


    Payment findByOrderId(int orderId);
}

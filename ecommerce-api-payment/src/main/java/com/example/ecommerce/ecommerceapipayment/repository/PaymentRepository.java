package com.example.ecommerce.ecommerceapipayment.repository;

import com.example.ecommerce.ecommerceapipayment.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}

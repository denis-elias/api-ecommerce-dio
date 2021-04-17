package com.example.ecommerce.ecommerceapipayment.service;

import com.example.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.example.ecommerce.ecommerceapipayment.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {

    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);

}

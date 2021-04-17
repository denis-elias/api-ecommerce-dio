package com.example.ecommerce.ecommerceapicheckout.service;

import com.example.ecommerce.ecommerceapicheckout.entity.CheckoutEntity;
import com.example.ecommerce.ecommerceapicheckout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

}

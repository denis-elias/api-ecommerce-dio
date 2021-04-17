package com.example.ecommerce.ecommerceapipayment.config;

import com.example.ecommerce.ecommerceapipayment.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
}

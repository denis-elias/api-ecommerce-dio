package com.example.ecommerce.ecommerceapicheckout.config;

import com.example.ecommerce.ecommerceapicheckout.streaming.CheckoutCreatedSource;
import com.example.ecommerce.ecommerceapicheckout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}

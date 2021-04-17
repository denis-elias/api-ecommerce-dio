package com.example.ecommerce.ecommerceapicheckout.listener;

import com.example.ecommerce.ecommerceapicheckout.entity.CheckoutEntity;
import com.example.ecommerce.ecommerceapicheckout.repository.CheckoutRepository;
import com.example.ecommerce.ecommerceapicheckout.streaming.PaymentPaidSink;
import com.example.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        checkoutRepository.save(checkoutEntity);
        event.getCheckoutCode();
    }

}

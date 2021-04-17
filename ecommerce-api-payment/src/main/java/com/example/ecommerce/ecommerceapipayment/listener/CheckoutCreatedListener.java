package com.example.ecommerce.ecommerceapipayment.listener;

import com.example.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.example.ecommerce.ecommerceapipayment.entity.PaymentEntity;
import com.example.ecommerce.ecommerceapipayment.service.PaymentService;
import com.example.ecommerce.ecommerceapipayment.streaming.CheckoutProcessor;
import com.example.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;
    private final PaymentService paymentService;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event) {
        final PaymentEntity paymentEntity = paymentService.create(event).orElseThrow();
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }

}

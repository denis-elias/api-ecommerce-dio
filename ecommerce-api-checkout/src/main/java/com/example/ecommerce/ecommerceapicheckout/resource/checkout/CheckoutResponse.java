package com.example.ecommerce.ecommerceapicheckout.resource.checkout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutResponse implements Serializable {

    private String code;

}

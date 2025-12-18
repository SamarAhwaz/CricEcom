package com.example.cricEcom.ResponsDto;

import java.math.BigDecimal;

public record PaymentInitiatedResponseDto(
		Long paymentId,
        String razorpayOrderId,
        Integer amountInPaise) {

}

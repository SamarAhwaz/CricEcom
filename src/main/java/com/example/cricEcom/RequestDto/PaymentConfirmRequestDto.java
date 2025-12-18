package com.example.cricEcom.RequestDto;

public record PaymentConfirmRequestDto(
		 Long paymentId,
	        String razorpayOrderId,
	        String razorpayPaymentId,
	        String razorpaySignature) {

}

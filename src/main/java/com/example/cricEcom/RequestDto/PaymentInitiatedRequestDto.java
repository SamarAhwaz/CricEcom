package com.example.cricEcom.RequestDto;

import java.math.BigDecimal;

public record PaymentInitiatedRequestDto(
		 Long userId ,BigDecimal amount) {

	
}

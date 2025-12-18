	package com.example.cricEcom.ResponsDto;

import java.math.BigDecimal;
import java.util.List;

public record CartResponseDto(
		 Long cartId,
	        Long userId,BigDecimal  totalAmount,
        List<CartItemResponseDto> items) {

}

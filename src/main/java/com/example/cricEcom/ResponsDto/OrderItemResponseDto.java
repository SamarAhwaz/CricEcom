package com.example.cricEcom.ResponsDto;

import java.math.BigDecimal;

public record OrderItemResponseDto( 
//        Integer quantity,
//        BigDecimal unitPrice,
//        BigDecimal totalPrice
        
		
        String productName,
        int quantity,
        BigDecimal unitPrice,
        BigDecimal totalPrice) {

}

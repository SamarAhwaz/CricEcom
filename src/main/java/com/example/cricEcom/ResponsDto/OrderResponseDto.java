package com.example.cricEcom.ResponsDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.cricEcom.entities.Orders.OrderStatus;


public record OrderResponseDto (BigDecimal totalAmount,
		String status,
        LocalDateTime orderedAt,
        LocalDateTime updatedAt,
        List<OrderItemResponseDto> items){

}

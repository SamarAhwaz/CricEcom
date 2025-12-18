package com.example.cricEcom.RequestDto;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequestDto (Long userId,
        List<OrderItemRequestDto> items){

}

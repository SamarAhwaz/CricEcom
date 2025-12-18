package com.example.cricEcom.Service;

import java.util.List;

import com.example.cricEcom.RequestDto.OrderItemRequestDto;
import com.example.cricEcom.ResponsDto.OrderItemResponseDto;

public interface OrderItemService {
	OrderItemResponseDto createOrderItem(OrderItemRequestDto dto);

    OrderItemResponseDto getOrderItem(Long id);

    List<OrderItemResponseDto> getAllOrderItems();

}

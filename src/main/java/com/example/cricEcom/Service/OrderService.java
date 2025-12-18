package com.example.cricEcom.Service;

import java.util.List;

import com.example.cricEcom.RequestDto.OrderRequestDto;
import com.example.cricEcom.ResponsDto.OrderResponseDto;

public interface OrderService {
	 
	 
	 
	 
	 OrderResponseDto placeOrderDirect(OrderRequestDto dto);

	    OrderResponseDto placeOrderFromCart(Long userId);
	
	    OrderResponseDto getOrder(Long id);
	    List<OrderResponseDto> getAllOrders();

}

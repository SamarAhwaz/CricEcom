package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.cricEcom.RequestDto.OrderItemRequestDto;
import com.example.cricEcom.ResponsDto.OrderItemResponseDto;
import com.example.cricEcom.entities.OrderItem;

@Mapper(componentModel="spring",

		builder = @org.mapstruct.Builder(disableBuilder = true))
public interface OrderItemMapper {

	OrderItemResponseDto toDTO(OrderItem orderItem);

	// PARTIAL mapping: does NOT set order, product, unitPrice, totalPrice
//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "order", ignore = true)
//	@Mapping(target = "product", ignore = true)
//	@Mapping(target = "unitPrice", ignore = true)
//	@Mapping(target = "totalPrice", ignore = true)
	OrderItem toEntity(OrderItemRequestDto dto);

}

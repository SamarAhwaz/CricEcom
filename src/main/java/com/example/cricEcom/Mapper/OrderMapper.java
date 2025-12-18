package com.example.cricEcom.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.cricEcom.RequestDto.OrderRequestDto;
import com.example.cricEcom.ResponsDto.OrderItemResponseDto;
import com.example.cricEcom.ResponsDto.OrderResponseDto;
import com.example.cricEcom.entities.OrderItem;
import com.example.cricEcom.entities.Orders;

@Mapper(componentModel="spring")
public interface OrderMapper {
		
//	@Mapping(target = "id", ignore = true)
//    @Mapping(target = "orderedAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "user", ignore = true)
//    @Mapping(target = "items", ignore = true)
//    @Mapping(target = "orderStatus", ignore = true)
//	Orders toEntity(OrderRequestDto dto);
//
//    OrderResponseDto toDTO(Orders order);
	
    
	@Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "items", ignore = true)
    @Mapping(target = "totalAmount", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)
    @Mapping(target = "orderedAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Orders toEntity(OrderRequestDto dto);

    // Convert Order → Response DTO
    @Mapping(source = "orderStatus", target = "status")
    OrderResponseDto toDTO(Orders order);

    // Convert OrderItem list → Response list
//    @Mapping(source = "product.productName", target = "productName")
    OrderItemResponseDto toOrderItemResponseDto(OrderItem item);

    List<OrderItemResponseDto> toOrderItemResponseDtoList(List<OrderItem> items);
}

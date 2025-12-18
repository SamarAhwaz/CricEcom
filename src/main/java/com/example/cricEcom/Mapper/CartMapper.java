package com.example.cricEcom.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.cricEcom.ResponsDto.CartItemResponseDto;
import com.example.cricEcom.ResponsDto.CartResponseDto;
import com.example.cricEcom.entities.Cart;
import com.example.cricEcom.entities.CartItem;

@Mapper(componentModel = "spring")
public interface CartMapper {

	
////	
//	      @Mapping(source = "variant.id", target = "variantId")
    @Mapping(source = "variant.product.productName", target = "productName")
    @Mapping(source = "variant.price", target = "productPrice")
    CartItemResponseDto toCartItemDto(CartItem cartItem);

    List<CartItemResponseDto> toItemResponseList(List<CartItem> items);

    // Map Cart → CartResponseDto
    @Mapping(target = "cartId", source = "id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(
        target = "totalAmount",
        expression = "java(cart.getItems().stream()"
                + ".map(i -> i.getVariant().getPrice().multiply(java.math.BigDecimal.valueOf(i.getQuantity())))"
                + ".reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add))"
    )
    @Mapping(target = "items", expression = "java(toItemResponseList(cart.getItems()))")
    CartResponseDto toDto(Cart cart);
}

package com.example.cricEcom.ResponsDto;

public record CartItemResponseDto(Long id,
        Long productId,
        String productName,
        double productPrice,
        int quantity) {

}

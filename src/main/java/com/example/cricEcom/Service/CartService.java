package com.example.cricEcom.Service;

import com.example.cricEcom.RequestDto.CartRequestDto;
import com.example.cricEcom.ResponsDto.CartResponseDto;

public interface CartService {
	
	
	CartResponseDto addToCart(Long userId, CartRequestDto request);
    CartResponseDto getCart(Long userId);
    CartResponseDto removeFromCart(Long userId, Long productId);

}

package com.example.cricEcom.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricEcom.RequestDto.CartRequestDto;
import com.example.cricEcom.ResponsDto.CartResponseDto;
import com.example.cricEcom.Service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;

    @PostMapping("/{userId}/add")
    public CartResponseDto addToCart(
            @PathVariable Long userId,
            @RequestBody CartRequestDto request
    ) {
        return cartService.addToCart(userId, request);
    }

    @GetMapping("/{userId}")
    public CartResponseDto getCart(@PathVariable Long userId) {
        return cartService.getCart(userId);
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public CartResponseDto removeItem(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        return cartService.removeFromCart(userId, productId);
    }
}
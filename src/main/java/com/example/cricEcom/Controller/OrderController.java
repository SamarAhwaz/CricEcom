package com.example.cricEcom.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricEcom.RequestDto.OrderRequestDto;
import com.example.cricEcom.ResponsDto.OrderResponseDto;
import com.example.cricEcom.Service.OrderService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("direct")
	 public ResponseEntity<OrderResponseDto> placeDirect(@RequestBody @Validated OrderRequestDto dto) {
        OrderResponseDto response = orderService.placeOrderDirect(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Place an order from the user's cart.
     * In production you'd use authenticated principal; here we accept a path variable userId.
     */
    @PostMapping("cart")
    public ResponseEntity<OrderResponseDto> placeFromCart(@RequestBody Long userId) {
        OrderResponseDto response = orderService.placeOrderFromCart(userId);
        return ResponseEntity.ok(response);
    }

	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.getOrder(id));
	}

	@GetMapping
	public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}
}

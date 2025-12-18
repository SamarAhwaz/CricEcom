package com.example.cricEcom.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricEcom.RequestDto.OrderItemRequestDto;
import com.example.cricEcom.ResponsDto.OrderItemResponseDto;
import com.example.cricEcom.Service.OrderItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orderitems")
@RequiredArgsConstructor
public class OrderItemController {

	private final OrderItemService orderItemService;

	@PostMapping("create")
	public ResponseEntity<OrderItemResponseDto> create(@RequestBody OrderItemRequestDto dto) {
		return ResponseEntity.ok(orderItemService.createOrderItem(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderItemResponseDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok(orderItemService.getOrderItem(id));
	}

	@GetMapping
	public ResponseEntity<List<OrderItemResponseDto>> getAll() {
		return ResponseEntity.ok(orderItemService.getAllOrderItems());
	}
}

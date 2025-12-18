package com.example.cricEcom.ServiceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cricEcom.Mapper.OrderItemMapper;
import com.example.cricEcom.Repo.OrderItemRepo;
import com.example.cricEcom.Repo.OrderRepo;
import com.example.cricEcom.Repo.ProductRepo;
import com.example.cricEcom.RequestDto.OrderItemRequestDto;
import com.example.cricEcom.ResponsDto.OrderItemResponseDto;
import com.example.cricEcom.Service.OrderItemService;
import com.example.cricEcom.entities.OrderItem;
import com.example.cricEcom.entities.Orders;
import com.example.cricEcom.entities.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImplementation implements OrderItemService {

	    private final OrderRepo orderRepo;
	    private final ProductRepo productRepo;
	    private final OrderItemRepo orderItemRepo;
	    private final OrderItemMapper mapper; // Only for entity → responseDTO

	    @Override
	    public OrderItemResponseDto createOrderItem(OrderItemRequestDto dto) {

	        // Fetch order
//	    	Orders order = orderRepo.findById(dto.orderId())
//	                .orElseThrow(() -> new RuntimeException("Order not found"));

	        Product product = productRepo.findById(dto.productId())
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        // Partial convert from MapStruct
	        OrderItem item = mapper.toEntity(dto);

//	        item.setOrder(order);
//	        item.setProduct(product);
//	        item.setUnitPrice(product.getPrice());

	        // @PrePersist will calculate totalPrice
	        item = orderItemRepo.save(item);

	        return mapper.toDTO(item); // Only response mapping
	    }

	    @Override
	    public OrderItemResponseDto getOrderItem(Long id) {
	        OrderItem item = orderItemRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
	        return mapper.toDTO(item);
	    }

	    @Override
	    public List<OrderItemResponseDto> getAllOrderItems() {
	        return orderItemRepo.findAll()
	                .stream()
	                .map(mapper::toDTO)
	                .toList();
	    }
	}



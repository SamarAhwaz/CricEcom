package com.example.cricEcom.ServiceImplementation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cricEcom.Helper.OrderItemBuilder;
import com.example.cricEcom.Mapper.OrderMapper;
import com.example.cricEcom.Repo.CartItemRepo;
import com.example.cricEcom.Repo.CartRepo;
import com.example.cricEcom.Repo.OrderRepo;
import com.example.cricEcom.Repo.ProductRepo;
import com.example.cricEcom.Repo.ProductVariantRepo;
import com.example.cricEcom.Repo.UserRepo;
import com.example.cricEcom.RequestDto.OrderItemRequestDto;
import com.example.cricEcom.RequestDto.OrderRequestDto;
import com.example.cricEcom.ResponsDto.OrderItemResponseDto;
import com.example.cricEcom.ResponsDto.OrderResponseDto;
import com.example.cricEcom.Service.OrderService;
import com.example.cricEcom.entities.Cart;
import com.example.cricEcom.entities.CartItem;
import com.example.cricEcom.entities.OrderItem;
import com.example.cricEcom.entities.Orders;
import com.example.cricEcom.entities.Product;
import com.example.cricEcom.entities.ProductVariant;
import com.example.cricEcom.entities.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {

	   
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final OrderMapper orderMapper;
    private final OrderItemBuilder orderItemBuilder;
    private final CartRepo cartRepo;
    private final CartItemRepo cartItemRepo;
    private final ProductVariantRepo variantRepo;




//	@Override
//	public OrderResponseDto createOrder(OrderRequestDto dto) {
//
//		User user = userRepository.findById(dto.userId()).orElseThrow(() -> new RuntimeException("User not found"));
//
//		Orders order = Orders.builder().user(user).orderStatus(Orders.OrderStatus.PENDING).build();
//
//		List<OrderItem> orderItems = dto.items().stream().map(itemReq -> {
//
//			Product product = productRepository.findById(itemReq.productId())
//					.orElseThrow(() -> new RuntimeException("Product not found"));
//
//			return OrderItem.builder().order(order).product(product).quantity(itemReq.quantity())
//					.unitPrice(product.getPrice()).build();
//
//		}).toList();
//
//		order.setItems(orderItems);
//
//		Orders saved = orderRepository.save(order); // triggers @PrePersist (= calculate totals)
//
//		return mapper.toDTO(saved);
	//}
	
	
	

	    
	    /* ------------------------------------------------
	       1) Place order directly: dto contains userId + items
	       - Uses productRepo.findByIdForUpdate(...) to lock product rows
	       - Builds orderItems, reduces stock, calculates totals
	       - Saves order atomically inside @Transactional
	       ------------------------------------------------ */

        // ----------------------------------------------------------
        // 1. DIRECT ORDER
        // ----------------------------------------------------------
        @Override
        @Transactional
        public OrderResponseDto placeOrderDirect(OrderRequestDto dto) {

            Orders order = orderMapper.toEntity(dto);

            User user = userRepo.findById(dto.userId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            order.setUser(user);
            order.setOrderStatus(Orders.OrderStatus.PENDING);

            List<OrderItem> orderItems = new ArrayList<>();
            BigDecimal total = BigDecimal.ZERO;

            for (OrderItemRequestDto it : dto.items()) {

                Product product = productRepo.findByIdForUpdate(it.productId())
                        .orElseThrow(() -> new IllegalArgumentException("Product not found: " + it.productId()));

//                OrderItem orderItem = orderItemBuilder.build(order, product, it.quantity());

//                orderItems.add(orderItem);
//                total = total.add(orderItem.getTotalPrice());
            }

            order.setItems(orderItems);
            order.setTotalAmount(total);

            Orders saved = orderRepo.save(order);

            // ✔ DIRECT return using mapper
            return orderMapper.toDTO(saved);
        }


        // ----------------------------------------------------------
        // 2. PLACE ORDER FROM CART
        // ----------------------------------------------------------
        @Override
        @Transactional
        public OrderResponseDto placeOrderFromCart(Long userId) {

            User user = userRepo.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            Cart cart = cartRepo.findByUser(user)
                    .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

            if (cart.getItems() == null || cart.getItems().isEmpty()) {
                throw new IllegalStateException("Cart is empty");
            }

            Orders order = new Orders();
            order.setUser(user);
            order.setOrderStatus(Orders.OrderStatus.PENDING);

            List<OrderItem> orderItems = new ArrayList<>();
            BigDecimal total = BigDecimal.ZERO;

            for (CartItem ci : cart.getItems()) {
            	
//            	ProductVariant variant = variantRepo.findByIdForUpdate(ci.getVariant().getId())
//            	        .orElseThrow(() -> new IllegalArgumentException("Variant not found"));


//                OrderItem orderItem = orderItemBuilder.build(order, product, ci.getQuantity());

//                orderItems.add(orderItem);
//                total = total.add(orderItem.getTotalPrice());
            }

            order.setItems(orderItems);
            order.setTotalAmount(total);

            Orders saved = orderRepo.save(order);

            // Clear cart
            cartItemRepo.deleteAll(cart.getItems());
            cart.getItems().clear();
            cartRepo.save(cart);

            // ✔ DIRECT return using mapper
            return orderMapper.toDTO(saved);
        }


        // ----------------------------------------------------------
        // 3. GET ORDER BY ID
        // ----------------------------------------------------------
        @Override
        public OrderResponseDto getOrder(Long id) {
            Orders order = orderRepo.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Order not found"));
            return orderMapper.toDTO(order);
        }

        // ----------------------------------------------------------
        // 4. GET ALL ORDERS
        // ----------------------------------------------------------
        @Override
        public List<OrderResponseDto> getAllOrders() {
            return orderRepo.findAll()
                    .stream()
                    .map(orderMapper::toDTO)
                    .toList();
        }
    }



	package com.example.cricEcom.ServiceImplementation;
	
	import org.springframework.stereotype.Service;
	
	import com.example.cricEcom.Mapper.CartMapper;
	import com.example.cricEcom.Repo.CartItemRepo;
	import com.example.cricEcom.Repo.CartRepo;
	import com.example.cricEcom.Repo.ProductRepo;
import com.example.cricEcom.Repo.ProductVariantRepo;
import com.example.cricEcom.Repo.UserRepo;
	import com.example.cricEcom.RequestDto.CartRequestDto;
	import com.example.cricEcom.ResponsDto.CartResponseDto;
	import com.example.cricEcom.Service.CartService;
	import com.example.cricEcom.entities.Cart;
	import com.example.cricEcom.entities.CartItem;
	import com.example.cricEcom.entities.Product;
import com.example.cricEcom.entities.ProductVariant;
import com.example.cricEcom.entities.User;
	
	import lombok.RequiredArgsConstructor;
	
	
	@Service
	@RequiredArgsConstructor
	//@Transactional
	public class CartServiceImplementation implements CartService{
	
		private final CartRepo cartRepository;
	    private final CartItemRepo cartItemRepository;
	    private final ProductRepo productRepository;
	    private final UserRepo userRepository;  // assumes exists
	    private final CartMapper cartMapper;
	    private final ProductVariantRepo productVariantRepo;
	
	    @Override
	    public CartResponseDto addToCart(Long userId, CartRequestDto req) {
	
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	
	        Cart cart = cartRepository.findByUserId(userId)
	                .orElseGet(() -> {
	                    Cart c = new Cart();
	                    c.setUser(user);
	                    return cartRepository.save(c);
	                });
	        ProductVariant variant = productVariantRepo.findById(req.varientId())
	                .orElseThrow(() -> new RuntimeException("Variant not found"));

	        CartItem item = cartItemRepository.findByCartIdAndVariantId(cart.getId(), variant.getId())
	                .orElseGet(() -> CartItem.builder()
	                        .cart(cart)
	                        .variant(variant)
	                        .quantity(0)
	                        .build());

	
	        item.setQuantity(item.getQuantity() + req.quantity());
	        cartItemRepository.save(item);
	
	        return cartMapper.toDto(cartRepository.findById(cart.getId()).get());
	    }
	
	    @Override
	    public CartResponseDto getCart(Long userId) {
	        Cart cart = cartRepository.findByUserId(userId)
	                .orElseThrow(() -> new RuntimeException("Cart is empty"));
	        return cartMapper.toDto(cart);
	    }
	
	    @Override
	    public CartResponseDto removeFromCart(Long userId, Long productId) {
	
	        Cart cart = cartRepository.findByUserId(userId)
	                .orElseThrow(() -> new RuntimeException("Cart not found"));
	
	        CartItem item = cartItemRepository.findByCartIdAndVariantId(cart.getId(), productId)
	                .orElseThrow(() -> new RuntimeException("Product not in cart"));
	
	        cartItemRepository.delete(item);
	
	        return cartMapper.toDto(cart);
	
	}}

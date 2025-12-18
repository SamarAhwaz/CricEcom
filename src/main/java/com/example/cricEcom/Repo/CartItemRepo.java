package com.example.cricEcom.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
	Optional<CartItem> findByCartIdAndVariantId(Long cartId, Long variantId);
	}
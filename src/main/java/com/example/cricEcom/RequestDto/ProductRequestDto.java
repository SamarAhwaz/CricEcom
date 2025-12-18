package com.example.cricEcom.RequestDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.cricEcom.entities.ProductImage;

public record ProductRequestDto (
		
		
		
		 String productName,
		 String productDesc,
		 boolean availability,
		 BigDecimal 	price,
		 Integer stockQuantity,
		 String brand,
		 String productTypeName,
		 String subcategoryName
		 ) {}
	
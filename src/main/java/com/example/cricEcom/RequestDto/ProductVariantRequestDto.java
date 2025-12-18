package com.example.cricEcom.RequestDto;

import java.math.BigDecimal;

public record ProductVariantRequestDto(

		Long productId,

	     String variantName,

	     BigDecimal price,

	     Integer stockQuantity
	     ) {

}

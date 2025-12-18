package com.example.cricEcom.ResponsDto;

import java.math.BigDecimal;

public record ProductVariantResponeDto(
		
		 Long id,
	     String variantName,
	     BigDecimal price,
	     Integer stockQuantity,
	     Long productId
) {

}

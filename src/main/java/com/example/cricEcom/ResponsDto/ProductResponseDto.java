package com.example.cricEcom.ResponsDto;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDto (
		
		String productName,
		   Long id,
		String productDesc,
		boolean availability,
		BigDecimal price,
		Integer stockQuantity,
		String brand,
		List<ImageResponseDto> images)
{
}

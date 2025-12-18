package com.example.cricEcom.Service;

import java.util.List;

import com.example.cricEcom.RequestDto.ProductVariantRequestDto;
import com.example.cricEcom.ResponsDto.ProductVariantResponeDto;

public interface ProductVariantService {
	 ProductVariantResponeDto createVariant(ProductVariantRequestDto request);

	    ProductVariantResponeDto getVariantById(Long id);

	    List<ProductVariantResponeDto> getVariantsByProduct(Long productId);

	    ProductVariantResponeDto updateStock(Long variantId, Integer newStock);

	    ProductVariantResponeDto updatePrice(Long variantId, String newPrice);

	    void deleteVariant(Long id);

}

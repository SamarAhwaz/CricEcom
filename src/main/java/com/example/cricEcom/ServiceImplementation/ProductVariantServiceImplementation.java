package com.example.cricEcom.ServiceImplementation;

import java.util.List;

import com.example.cricEcom.RequestDto.ProductVariantRequestDto;
import com.example.cricEcom.ResponsDto.ProductVariantResponeDto;
import com.example.cricEcom.Service.ProductVariantService;

public class ProductVariantServiceImplementation implements ProductVariantService {

	@Override
	public ProductVariantResponeDto createVariant(ProductVariantRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVariantResponeDto getVariantById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVariantResponeDto> getVariantsByProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVariantResponeDto updateStock(Long variantId, Integer newStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVariantResponeDto updatePrice(Long variantId, String newPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVariant(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}

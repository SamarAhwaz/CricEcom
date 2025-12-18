package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.example.cricEcom.RequestDto.ProductVariantRequestDto;
import com.example.cricEcom.ResponsDto.ProductVariantResponeDto;
import com.example.cricEcom.entities.ProductVariant;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductVariantMapper {
	 @Mapping(target = "id", ignore = true)
	    @Mapping(target = "product", ignore = true)
	    ProductVariant toEntity(ProductVariantRequestDto dto);

	    // Entity → ResponseDTO
//	    @Mapping(target = "productId", source = "product.id")
	    ProductVariantResponeDto toResponse(ProductVariant variant);

}

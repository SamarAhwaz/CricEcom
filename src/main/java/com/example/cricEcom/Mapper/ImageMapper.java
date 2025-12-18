package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;

import com.example.cricEcom.RequestDto.ImageRequestDto;
import com.example.cricEcom.ResponsDto.ImageResponseDto;
import com.example.cricEcom.entities.ProductImage;

@Mapper(componentModel = "spring")
public interface ImageMapper {

	
	ImageResponseDto toDto(ProductImage image);
	ProductImage toEntity(ImageRequestDto dto);
}

package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;

import com.example.cricEcom.RequestDto.SubCategoryRequestDto;
import com.example.cricEcom.ResponsDto.SubCategoryResponseDto;
import com.example.cricEcom.entities.SubCategory;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
	
	SubCategoryResponseDto toDto(SubCategory subcategory);
	SubCategory toEntity(SubCategoryRequestDto dto);

}

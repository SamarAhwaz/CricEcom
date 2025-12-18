package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;

import com.example.cricEcom.RequestDto.CategoryRequestDto;
import com.example.cricEcom.ResponsDto.CategoryResponseDto;
import com.example.cricEcom.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	
	CategoryResponseDto toDto(Category category);
	Category toEntity(CategoryRequestDto dto);

}

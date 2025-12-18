package com.example.cricEcom.Service;

import com.example.cricEcom.RequestDto.CategoryRequestDto;
import com.example.cricEcom.ResponsDto.CategoryResponseDto;

public interface CategoryService {

	
	CategoryResponseDto createCategory(CategoryRequestDto dto);
	CategoryResponseDto getCategory();
	CategoryResponseDto getCategoryByid(Long id);
	CategoryResponseDto UpdateCategory(CategoryRequestDto dto);
	CategoryResponseDto deleteCategoryByid(Long id);
	CategoryResponseDto deleteCategory(Long id);
}

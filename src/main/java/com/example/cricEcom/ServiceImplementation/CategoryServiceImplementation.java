package com.example.cricEcom.ServiceImplementation;

import org.springframework.stereotype.Service;

import com.example.cricEcom.Mapper.CategoryMapper;
import com.example.cricEcom.Repo.CategoryRepo;
import com.example.cricEcom.RequestDto.CategoryRequestDto;
import com.example.cricEcom.ResponsDto.CategoryResponseDto;
import com.example.cricEcom.Service.CategoryService;
import com.example.cricEcom.entities.Category;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoryServiceImplementation implements CategoryService{

	private final CategoryRepo repo;
	private final CategoryMapper mapper;
	
	
	@Override
	public CategoryResponseDto createCategory(CategoryRequestDto dto) {
		
		Category category=mapper.toEntity(dto);
		repo.save(category);
		
		
		return mapper.toDto(category);
	}

	@Override
	public CategoryResponseDto getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponseDto getCategoryByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponseDto UpdateCategory(CategoryRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponseDto deleteCategoryByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponseDto deleteCategory(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

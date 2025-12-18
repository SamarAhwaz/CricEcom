package com.example.cricEcom.ServiceImplementation;

import org.springframework.stereotype.Service;

import com.example.cricEcom.Mapper.SubCategoryMapper;
import com.example.cricEcom.Repo.CategoryRepo;
import com.example.cricEcom.Repo.SubCategoryRepo;
import com.example.cricEcom.RequestDto.SubCategoryRequestDto;
import com.example.cricEcom.ResponsDto.SubCategoryResponseDto;
import com.example.cricEcom.Service.SubCategoryService;
import com.example.cricEcom.entities.Category;
import com.example.cricEcom.entities.SubCategory;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class SubCategoryServiceImplementation implements SubCategoryService{

	private final SubCategoryRepo subcategoryRepo;
	private final CategoryRepo categoryRepo;
	private final SubCategoryMapper subcategoryMapper;
	
	@Override
	public SubCategoryResponseDto create(SubCategoryRequestDto dto) {
		
		SubCategory subcategory=subcategoryMapper.toEntity(dto);
		
		Category category =categoryRepo.findByName(dto.categoryName())
		.orElseThrow(() -> new RuntimeException("Type not found"));
		
		subcategory.setCategory(category);
		
		subcategoryRepo.save(subcategory);
		
		return subcategoryMapper.toDto(subcategory);
	}

	@Override
	public SubCategoryResponseDto get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategoryResponseDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategoryResponseDto update(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategoryResponseDto delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategoryResponseDto deleteByiD(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

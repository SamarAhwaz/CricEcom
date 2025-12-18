package com.example.cricEcom.Service;

import com.example.cricEcom.RequestDto.SubCategoryRequestDto;
import com.example.cricEcom.ResponsDto.SubCategoryResponseDto;

public interface SubCategoryService {
	
	
	SubCategoryResponseDto create (SubCategoryRequestDto dto);
	SubCategoryResponseDto get();
	SubCategoryResponseDto getById(Long id);
	SubCategoryResponseDto  update(Long id);
	SubCategoryResponseDto  delete();
	SubCategoryResponseDto  deleteByiD(Long id);

}

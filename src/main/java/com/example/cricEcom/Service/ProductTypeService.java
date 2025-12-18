package com.example.cricEcom.Service;

import com.example.cricEcom.RequestDto.ProductRequestDto;
import com.example.cricEcom.RequestDto.ProductTypeRequestDto;
import com.example.cricEcom.ResponsDto.ProductTypeResponseDto;

public interface ProductTypeService {
	
	ProductTypeResponseDto create(ProductTypeRequestDto dto);
	ProductTypeResponseDto get();
	ProductTypeResponseDto getById( Long id);
	ProductTypeResponseDto Update(Long id);
	ProductTypeResponseDto  Delete(ProductTypeRequestDto dto);
	ProductTypeResponseDto  DeleteByid(Long id);

}

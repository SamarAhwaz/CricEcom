package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;

import com.example.cricEcom.Repo.ProductRepo;
import com.example.cricEcom.RequestDto.ProductRequestDto;
import com.example.cricEcom.ResponsDto.ProductResponseDto;
import com.example.cricEcom.entities.Product;


@Mapper(componentModel="spring")
public interface ProductMapper {
	
	ProductResponseDto toDto(Product product);
	
	Product toEntity(ProductRequestDto dto);

}

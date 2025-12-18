package com.example.cricEcom.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.example.cricEcom.RequestDto.AddStockRequestDto;
import com.example.cricEcom.RequestDto.ProductRequestDto;
import com.example.cricEcom.ResponsDto.ProductResponseDto;
import com.example.cricEcom.entities.Product;

public interface ProductService {

	List<ProductResponseDto> getAll();
	ProductResponseDto AddProduct(ProductRequestDto dto ,List<MultipartFile> file)throws IOException;
	String addStock(AddStockRequestDto dto);
}

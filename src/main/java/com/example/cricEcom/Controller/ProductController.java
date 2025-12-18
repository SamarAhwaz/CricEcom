package com.example.cricEcom.Controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.cricEcom.RequestDto.AddStockRequestDto;
import com.example.cricEcom.RequestDto.ProductRequestDto;
import com.example.cricEcom.ResponsDto.ProductResponseDto;
import com.example.cricEcom.Service.ProductService;
import com.example.cricEcom.entities.Product;

import lombok.RequiredArgsConstructor;

	
@CrossOrigin("*")
@RestController
@RequestMapping("/Product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productservice;

	@PostMapping("/product")
	public ProductResponseDto addproduct(@RequestPart ProductRequestDto dto, @RequestPart List<MultipartFile> file)
			throws IOException {
		return productservice.AddProduct(dto, file);
	}
	@GetMapping("/get")	
	public List<ProductResponseDto> getproduct() {
		return productservice.getAll();
	}
	@PostMapping("/AddStock")	
	public String AddStock(@RequestBody AddStockRequestDto dto)  {
		return productservice.addStock(dto);
	}

}

package com.example.cricEcom.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricEcom.Repo.CategoryRepo;
import com.example.cricEcom.RequestDto.CategoryRequestDto;
import com.example.cricEcom.ResponsDto.CategoryResponseDto;
import com.example.cricEcom.Service.CategoryService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

	
	private final CategoryService service;
	
	@PostMapping("/create")

	public CategoryResponseDto create (@RequestBody CategoryRequestDto dto ) {
		return service.createCategory(dto);
	}

}

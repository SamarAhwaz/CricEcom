package com.example.cricEcom.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricEcom.RequestDto.SubCategoryRequestDto;
import com.example.cricEcom.ResponsDto.SubCategoryResponseDto;
import com.example.cricEcom.Service.SubCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/subcategory")
@RequiredArgsConstructor
public class SubCategoryController {

	private final SubCategoryService service;
	
	@PostMapping("create")
	public SubCategoryResponseDto create(@RequestBody SubCategoryRequestDto dto) {
		return service.create(dto);
	}
}

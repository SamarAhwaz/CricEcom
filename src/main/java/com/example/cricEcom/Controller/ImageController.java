package com.example.cricEcom.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.cricEcom.RequestDto.ImageRequestDto;
import com.example.cricEcom.ResponsDto.ImageResponseDto;
import com.example.cricEcom.Service.ImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Image")
@RequiredArgsConstructor
public class ImageController {

	private final ImageService service;

	@PostMapping("/I")
	public List<ImageResponseDto> addimage(@RequestParam("files") List<MultipartFile> files) throws Exception{
		return service.addImage(files);
	}
}

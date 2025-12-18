package com.example.cricEcom.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.cricEcom.RequestDto.ImageRequestDto;
import com.example.cricEcom.ResponsDto.ImageResponseDto;

public interface ImageService {
	
	  List<ImageResponseDto> addImage(List<MultipartFile> files) throws IOException;
}

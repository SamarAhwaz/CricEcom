package com.example.cricEcom.ServiceImplementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.cricEcom.Mapper.ImageMapper;
import com.example.cricEcom.Repo.ImageRepo;


import com.example.cricEcom.RequestDto.ImageRequestDto;
import com.example.cricEcom.ResponsDto.ImageResponseDto;
import com.example.cricEcom.Service.ImageService;
import com.example.cricEcom.entities.ProductImage;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class ImageServiceImplementation implements ImageService{

	
	
	private final ImageRepo repo;
	private final ImageMapper mapper;
	
	
	@Override
	public List<ImageResponseDto> addImage(List<MultipartFile> files) throws IOException{
		 List<ImageResponseDto> list = new ArrayList<>();

		    for (MultipartFile file : files) {

		    	String base64 = 
		    			"data:" + file.getContentType() + ";base64," +
                        
		    			Base64.getEncoder().encodeToString(file.getBytes());
		   
		        ProductImage image = new ProductImage();
		        image.setProductImageUrl(base64);

		        repo.save(image);

		        list.add(new ImageResponseDto(base64));
		        System.out.println("LENGTH = " + base64.length());
		        
		    }


		    return list;}
}

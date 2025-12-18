package com.example.cricEcom.RequestDto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public record ImageRequestDto ( List<MultipartFile> file){

}

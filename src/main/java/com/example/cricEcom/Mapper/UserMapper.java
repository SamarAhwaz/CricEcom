package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;

import com.example.cricEcom.RequestDto.UserRequestDto;
import com.example.cricEcom.ResponsDto.UserResponseDto;
import com.example.cricEcom.entities.User;

@Mapper(componentModel="spring")
public interface UserMapper {
	User toEntity(UserRequestDto dto);

	    UserResponseDto toDTO(User user);

}

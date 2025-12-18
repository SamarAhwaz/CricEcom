package com.example.cricEcom.Service;

import java.util.List;

import com.example.cricEcom.RequestDto.UserRequestDto;
import com.example.cricEcom.ResponsDto.UserResponseDto;

public interface UserService {
	UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto getUser(Long id);

    List<UserResponseDto> getAllUsers();

}

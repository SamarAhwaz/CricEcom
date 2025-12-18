package com.example.cricEcom.ServiceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cricEcom.Mapper.UserMapper;
import com.example.cricEcom.Repo.UserRepo;
import com.example.cricEcom.RequestDto.UserRequestDto;
import com.example.cricEcom.ResponsDto.UserResponseDto;
import com.example.cricEcom.Service.UserService;
import com.example.cricEcom.entities.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

	  private final UserRepo userRepository;
	    private final UserMapper mapper;

	    @Override
	    public UserResponseDto createUser(UserRequestDto dto) {
	        User user = mapper.toEntity(dto);
	        User saved = userRepository.save(user);
	        return mapper.toDTO(saved);
	    }

	    @Override
	    public UserResponseDto getUser(Long id) {
	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        return mapper.toDTO(user);
	    }

	    @Override
	    public List<UserResponseDto> getAllUsers() {
	        return userRepository.findAll()
	                .stream()
	                .map(mapper::toDTO)
	                .toList();
	    }}

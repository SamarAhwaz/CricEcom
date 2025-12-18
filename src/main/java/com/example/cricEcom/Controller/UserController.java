package com.example.cricEcom.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricEcom.RequestDto.UserRequestDto;
import com.example.cricEcom.ResponsDto.UserResponseDto;
import com.example.cricEcom.Service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	 private final UserService userService;

	    @PostMapping
	    public ResponseEntity<UserResponseDto> create(@Valid  @RequestBody UserRequestDto dto) {
	        return ResponseEntity.ok(userService.createUser(dto));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
	        return ResponseEntity.ok(userService.getUser(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<UserResponseDto>> getAll() {
	        return ResponseEntity.ok(userService.getAllUsers());
	    }
}

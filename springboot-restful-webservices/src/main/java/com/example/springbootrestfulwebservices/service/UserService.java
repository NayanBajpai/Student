package com.example.springbootrestfulwebservices.service;

import java.util.List;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto getUserById(Long userId);
	List<UserDto> getAllUsers();
	UserDto updateUser(UserDto user);
	void deleteUser(Long userId);

}

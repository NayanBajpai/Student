package com.example.springbootrestfulwebservices.mapper;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;

public class UserMapper {
	
	public static UserDto mapToUserDto(User user) {
		
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFName(),
				user.getLName(),
				user.getEmail());
		
		return userDto;
	}
	
	public static User mapToUser(UserDto userDto) {
		
		User user = new User(
				userDto.getId(),
				userDto.getFName(),
				userDto.getLName(),
				userDto.getEmail());
		
		return user;
	}

}

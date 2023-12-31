package com.example.springbootrestfulwebservices.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.mapper.UserMapper;
import com.example.springbootrestfulwebservices.repository.UserRepository;
import com.example.springbootrestfulwebservices.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = UserMapper.mapToUser(userDto);
		
		User savedUser = userRepository.save(user);
		
		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		
		return savedUserDto;
		
				
	}

	@Override
	public UserDto getUserById(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(UserMapper::mapToUserDto)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFName(user.getFName());
		existingUser.setLName(user.getLName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
		return UserMapper.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

}

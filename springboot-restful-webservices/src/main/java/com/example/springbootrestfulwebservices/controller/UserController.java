package com.example.springbootrestfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
		UserDto user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
			                               @RequestBody UserDto user){
		user.setId(userId);
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("User Successfully Deleted", HttpStatus.OK);
	}

}

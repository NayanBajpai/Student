package com.example.springbootrestfulwebservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	private String fName;
	private String lName;
	private String email;

}

package com.app.BlogApp.service;

import java.util.List;

import com.app.BlogApp.paylods.UserDto;

public interface UserServiceI {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer userId);
	
}

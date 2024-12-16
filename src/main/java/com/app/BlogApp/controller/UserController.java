package com.app.BlogApp.controller;

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

import com.app.BlogApp.paylods.ApiResponse;
import com.app.BlogApp.paylods.UserDto;
import com.app.BlogApp.service.UserServiceI;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceI userServiceI;

	@PostMapping(value = "/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto user = this.userServiceI.createUser(userDto);
		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);

	}

	@PutMapping(value = "/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userdto, @PathVariable Integer userId) {

		UserDto updateUser = this.userServiceI.updateUser(userdto, userId);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		this.userServiceI.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted", true), HttpStatus.OK);
	}

	@GetMapping(value="/getAllUser")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUser = this.userServiceI.getAllUser();
		return new ResponseEntity<List<UserDto>>(allUser,HttpStatus.OK);
	}
	
	@GetMapping(value="/getById/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServiceI.getUserById(userId));
	}
	
}

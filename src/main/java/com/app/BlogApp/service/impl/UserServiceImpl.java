package com.app.BlogApp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BlogApp.exceptions.ResourceNotFoundException;
import com.app.BlogApp.models.User;
import com.app.BlogApp.paylods.UserDto;
import com.app.BlogApp.repository.UserRepository;
import com.app.BlogApp.service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User save = this.userRepository.save(user);
		return this.userToDto(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=this.userRepository
				.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
		User updateUser = this.userRepository.save(user);
		
		return this.userToDto(updateUser);
		
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
			.orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepository.findAll();
		List<UserDto> userList = users.stream()
				.map(u-> this.userToDto(u))
				.collect(Collectors.toList());
		return userList;
	}

	@Override
	public void deleteUser(Integer userId) {
	 User user = this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		this.userRepository.delete(user);
		
	}
	
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
		
	}
	
	private UserDto userToDto(User user) {
		UserDto userDto =this.modelMapper.map(user, UserDto.class);
		return userDto;
		
	}

}

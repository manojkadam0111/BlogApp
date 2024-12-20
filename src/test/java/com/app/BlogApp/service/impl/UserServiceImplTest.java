package com.app.BlogApp.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.BlogApp.models.User;
import com.app.BlogApp.paylods.UserDto;
import com.app.BlogApp.repository.UserRepository;


@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

	
	
	@Mock
	private UserRepository repository;
	
	@InjectMocks
	private UserServiceImpl serviceImpl;
	
	  @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	
	@Test
	void testCreateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserById() {
//		User user1 = new User(1, "Manoj Kadam","manoj@gmail.com","Pass@123","java devloper ...");
//		User user2 = new User(2, "Adi Thorve","adi@gmail.com","Pass@1234","java Teacher ...");
	}

	@Test
	void testGetAllUser() {
	
//		User user1 = new User(1, "Manoj Kadam","manoj@gmail.com","Pass@123","java devloper ...");
//		User user2 = new User(2, "Adi Thorve","adi@gmail.com","Pass@1234","java Teacher ...");
//	 List<User> list = List.of(user1,user2);
//	 System.out.println(list);
		//when(repository.findAll()).thenReturn(list);
		
		List<UserDto> userDto=serviceImpl.getAllUser();
		
		 assertNotNull(userDto);
		 assertEquals(2, userDto.size());
		 
		 verify(repository, times(1)).findAll();
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

}

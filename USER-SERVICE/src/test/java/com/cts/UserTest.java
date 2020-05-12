package com.cts;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.entity.User;
import com.cts.repository.UserDao;
import com.cts.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserService userService;
	@MockBean
	private UserDao userDao;

	@Test
	public void saveUserTest() {
		User user=new User(3,"John","sara","john123","appu@gmail.com");
		when(userDao.save(user)).thenReturn(user);
		assertEquals(user,userService.addUser(user));	
	}
	
	@Test
	public void findByEmailTest() {
		User user= new User(3,"John","sara","john123","johnabraham@gmail.com");
		when(userDao.findByEmail("appu@123")).thenReturn(user);
		
	}
	
}

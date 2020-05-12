package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.repository.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao repo;

	public User addUser(User user) {
		
		return repo.save(user);
		
	}

	public<List> User getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Iterable<User> findAll() {
		
		return repo.findAll();
	}
}


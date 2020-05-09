package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.UserDao;
import com.cts.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao repo;

	public User addUser(User user) {
		
		return repo.save(user);
		
	}

	public User getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Iterable<User> findAll() {
		
		return repo.findAll();
	}
}


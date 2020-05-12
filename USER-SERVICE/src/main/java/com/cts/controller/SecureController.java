package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.User;
import com.cts.service.UserService;

@RestController
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}

	
	@PostMapping(value = "/user/email") 
	public User findByEmail(@RequestBody String email) { return
	  userService.getByEmail(email); 
	}
  
	@PostMapping(value = "/user/update") 
	public User updateUser(@RequestBody User user) {
		return userService.addUser(user); 
	} 
}

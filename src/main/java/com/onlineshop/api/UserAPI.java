package com.onlineshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.entity.UserEntity;
import com.onlineshop.service.impl.UserService;


@CrossOrigin
@RestController
public class UserAPI {
	@Autowired
	UserService userService;
	
	//create new User
//	@PostMapping(value="/user")
//	public UserEntity createUser(@RequestBody UserEntity user) {
//		UserEntity request = userService.createUser(user);
//		return request;
//	}
	@GetMapping(value = "/user/{email}/{password}")
	public UserEntity getUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
		UserEntity user = userService.getUserByEmailAndPassword(email, password);
		return user;
	}
	@PutMapping(value = "/user/{id}")
	public UserEntity updateUserID(@RequestBody UserEntity user, @PathVariable("id") Long id) {
//		user.setId(id);
		return userService.updateUser(user, id);
	}

	
}

package com.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.entity.UserEntity;
import com.onlineshop.repository.UserRepository;
import com.onlineshop.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserEntity createUser(UserEntity user) {

		//to save new record
		user.setId(null);
		user = userRepository.save(user);
		return user;
	}
}

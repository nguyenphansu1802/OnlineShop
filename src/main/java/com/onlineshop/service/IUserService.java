package com.onlineshop.service;

import com.onlineshop.entity.UserEntity;

public interface IUserService {
	
	public UserEntity getUserByEmailAndPassword(String email, String password);
	public UserEntity updateUser(UserEntity user, Long id);
}



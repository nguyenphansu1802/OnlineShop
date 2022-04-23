package com.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.entity.AccountEntity;
import com.onlineshop.entity.UserEntity;
import com.onlineshop.repository.AccountRepository;
import com.onlineshop.repository.UserRepository;
import com.onlineshop.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	AccountRepository accountRepository;
	
	
	@Override
	public UserEntity getUserByEmailAndPassword(String email, String password) {
		UserEntity user = userRepository.findOneByEmail(email);
		AccountEntity account = accountRepository.findOneByUser(user);

		if (account == null || !account.getPassword().equals(password))
			return null;
		return user;
	}

	@Override
	public UserEntity updateUser(UserEntity user, Long id) {
		UserEntity userCurrent = userRepository.findOneById(id);
		AccountEntity account = accountRepository.findOneByUser(user);
		if(userRepository.findByEmail(user.getEmail()).size()>1)
			return null;
		
		//to update
		userCurrent.setName(user.getName());
		userCurrent.setGender(user.getGender());
		userCurrent.setDateOfBirth(user.getDateOfBirth());
		
		UserEntity userUpdate = userRepository.save(userCurrent);
		return userUpdate;
	}
	
	
}

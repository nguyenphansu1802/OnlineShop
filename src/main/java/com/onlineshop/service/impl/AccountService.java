package com.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlineshop.entity.AccountEntity;
import com.onlineshop.entity.UserEntity;
import com.onlineshop.repository.AccountRepository;
import com.onlineshop.repository.UserRepository;
import com.onlineshop.service.IAccountService;

@Service
public class AccountService implements IAccountService{
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	UserRepository userRepository;
	@Override
	public AccountEntity findAccountByUserid(Long userid) {
		UserEntity user = new UserEntity();
		user.setId(userid);
		AccountEntity accountEntity = accountRepository.findOneByUser(user); 
		return accountEntity;
	}
	
	@Override
	public AccountEntity createAccount(AccountEntity account) {
		//to create a new account
		account.setId(null);
		UserEntity user = account.getUser();
		
		if(userRepository.findByEmail(user.getEmail()).size()>0)
			return null;

		user.setId(null);
		user = userRepository.save(user);
		
		account.setUser(user);
		account = accountRepository.save(account);
		return account;
	}
	@Override
	public AccountEntity forgetPassword(AccountEntity account, String email) {
		
		UserEntity user = userRepository.findOneByEmail(email);
		AccountEntity accountCurrent = accountRepository.findOneByUser(user);
		accountCurrent.setPassword(account.getPassword());
		accountCurrent.setStatus(account.getPassword());
		if (accountCurrent.getId() != null)
			accountRepository.save(accountCurrent);
		else 
			return null;
		return accountCurrent;
		
	}
	@Override
	public AccountEntity changePassword(AccountEntity account, String email) {
		
		UserEntity user = userRepository.findOneByEmail(email);
		AccountEntity account2 = accountRepository.findOneByUser(user);
		account.setId(account2.getId());
		if (account2.getId() != null && account.getStatus().equals(account2.getPassword()))
			account = accountRepository.save(account);
		else 
			return null;
		return account;
	}
}

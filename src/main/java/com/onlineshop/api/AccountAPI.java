package com.onlineshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.entity.AccountEntity;
import com.onlineshop.service.impl.AccountService;

@CrossOrigin
@RestController
public class AccountAPI {
	@Autowired
	AccountService accountService;
	
	//create new User
	@PostMapping(value="/account")
	public AccountEntity createAccount(@RequestBody AccountEntity account) {
		account = accountService.createAccount(account);
		return account;
	}
	
	@GetMapping(value="/account/{userid}")
	public AccountEntity getAccountByUserid(@PathVariable("userid") Long userid) {
		AccountEntity account = accountService.findAccountByUserid(userid);
		return account;
	}
	@PutMapping(value="/account/forgetpass/{email}")
	public AccountEntity forgetPassword(@RequestBody AccountEntity account, @PathVariable("email") String email) {
		return accountService.forgetPassword(account,email);
	}
	@PutMapping(value="/account/{email}")
	public AccountEntity changePassword(@RequestBody AccountEntity account, @PathVariable("email") String email) {
		return accountService.changePassword(account,email);
	}
}

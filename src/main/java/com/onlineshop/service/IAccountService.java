package com.onlineshop.service;

import com.onlineshop.entity.AccountEntity;

public interface IAccountService {
	public AccountEntity findAccountByUserid(Long userid);
	public AccountEntity createAccount(AccountEntity account);
	public AccountEntity forgetPassword(AccountEntity account, String email);
	public AccountEntity changePassword(AccountEntity account, String email);
}

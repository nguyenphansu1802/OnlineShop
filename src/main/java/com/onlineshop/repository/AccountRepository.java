package com.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.AccountEntity;
import com.onlineshop.entity.UserEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	public AccountEntity findOneByUser(UserEntity user);
	
}

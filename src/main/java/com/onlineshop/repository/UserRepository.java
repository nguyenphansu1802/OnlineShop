package com.onlineshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	public UserEntity save(UserEntity entity);
	public  UserEntity findOneByEmail(String email);
	public  List<UserEntity> findByEmail(String email);
	public UserEntity findOneById(Long id);
}
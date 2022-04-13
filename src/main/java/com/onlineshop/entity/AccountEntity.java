package com.onlineshop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class AccountEntity extends BaseEntity{
	@Column(name="password")
	private String password;
	
	@Column(name= "status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private UserEntity user;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}

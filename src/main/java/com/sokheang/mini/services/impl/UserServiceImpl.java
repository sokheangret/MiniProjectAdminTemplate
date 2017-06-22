package com.sokheang.mini.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sokheang.mini.model.User;
import com.sokheang.mini.repositories.imp.UserRepositoryImpl;
import com.sokheang.mini.services.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	private UserRepositoryImpl userRepositoryImpl;
	
	@Autowired
	public UserServiceImpl(@Qualifier("userRepositoryImpl") UserRepositoryImpl userRepositoryImpl) {
		this.userRepositoryImpl=userRepositoryImpl;
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepositoryImpl.getAllUser();
	}

	@Override
	public boolean addUser(User user) {
		return userRepositoryImpl.addUser(user);
	}

}

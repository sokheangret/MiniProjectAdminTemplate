package com.sokheang.mini.services;

import java.util.List;

import com.sokheang.mini.model.User;

public interface UserService {
	public List<User> getAllUser();
	public boolean addUser(User user);
}

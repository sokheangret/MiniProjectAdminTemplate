package com.sokheang.mini.repositories;

import java.util.List;

import com.sokheang.mini.model.User;

public interface UserRepository {
	public List<User> getAllUser();
	public boolean addUser(User user);
}
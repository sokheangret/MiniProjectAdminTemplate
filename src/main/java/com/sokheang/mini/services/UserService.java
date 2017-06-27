package com.sokheang.mini.services;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sokheang.mini.model.User;

public interface UserService {
	public List<User> getAllUser();
	public boolean addUser(User user);
	public User getUserProfile(String userHash);
	public boolean deleteByUserHash(String userHash);
	public boolean updateByUserHash(User user);
	public int countUser();
	public int countMale();
	public int countFemale();
	public int countActive();
}

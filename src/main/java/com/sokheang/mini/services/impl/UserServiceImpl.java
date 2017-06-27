package com.sokheang.mini.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sokheang.mini.model.User;
import com.sokheang.mini.repositories.UserRepository;
import com.sokheang.mini.services.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(@Qualifier("userRepository") UserRepository userRepositoryImpl) {
		this.userRepository=userRepositoryImpl;
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.getAllUser();
	}

	@Override
	public boolean addUser(User user) {
		String user_hash = UUID.randomUUID().toString();
		user.setUser_hash(user_hash);
		user.setStatus("Y");
		boolean status = userRepository.addUser(user);
		if(status){
			System.out.println("User input successfully");
		}
		else{
			System.out.println("User input field");
		}
		return status;
	}
	
	@Override
	public boolean deleteByUserHash(String userHash) {
		boolean status = userRepository.deleteUser(userHash);
		if(status){
			System.out.println("User deleted successfully");
		}
		else{
			System.out.println("User delete field");
		}
		return status;
	}
	@Override
	public boolean updateByUserHash(User user) {
		boolean status = userRepository.updateUser(user);
		
		System.out.println(user.getId()+' '+user.getUsername()+' '+user.getPhonenumber()+' '+user.getStatus()+' '+user.getUser_hash());
		if(status){
			System.out.println("User updated successfully");
		}
		else{
			System.out.println("User update field");
		}
		return status;
	}
	@Override
	public User getUserProfile(String userHash) {
		return userRepository.getUserProfile(userHash);
		
	}
	@Override
	public int countUser() {
		return userRepository.countUser();
	}
	@Override
	public int countMale() {
		// TODO Auto-generated method stub
		return userRepository.countMale();
	}
	@Override
	public int countFemale() {
		// TODO Auto-generated method stub
		return userRepository.countFemale();
	}
	@Override
	public int countActive() {
		// TODO Auto-generated method stub
		return userRepository.countActive();
	}

}

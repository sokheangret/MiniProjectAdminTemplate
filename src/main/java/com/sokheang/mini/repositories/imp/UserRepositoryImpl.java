package com.sokheang.mini.repositories.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sokheang.mini.model.User;
import com.sokheang.mini.repositories.UserRepository;

@Repository("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository{

	private List<User> lst = new ArrayList<>();
	private boolean check=true;
	@Override
	public List<User> getAllUser() {
		if(check){
			lst.add(new User(1,"Ret Sokheang","sokheangret","Male","sokheangret@gmail.com",1,"123456"));
			lst.add(new User(2,"Moeurn Chanrath","chanrathmoeurn","Female","chanrathmoerun@gmail.com",2,"654321"));
		}
		check=false;
		System.out.println("Array size "+lst.size());
		return lst;
	}

	@Override
	public boolean addUser(User user) {
		if(user!=null){
			lst.add(user);
			System.out.println("Added to arrlist");
			return true;
		}
		return false;
	}

}



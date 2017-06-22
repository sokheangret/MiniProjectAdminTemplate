package com.sokheang.mini.repositories.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sokheang.mini.model.Role;
import com.sokheang.mini.repositories.RoleRepository;

@Repository("roleRepositoryImpl")
public class RoleRepositoryImpl implements RoleRepository{

	private List<Role> lst = new ArrayList<>();
	private boolean check=true;
	@Override
	public List<Role> getAllRole() {
		if(check){
			lst.add(new Role(1,"Admin"));
			lst.add(new Role(2,"User"));
		}
		check=false;
		System.out.println("Array size "+lst.size());
		return lst;
	}

	@Override
	public boolean addRole(Role role) {
		if(role!=null){
			lst.add(role);
			return true;
		}
		return false;
	}

}

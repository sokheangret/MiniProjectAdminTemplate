package com.sokheang.mini.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sokheang.mini.model.Role;
import com.sokheang.mini.repositories.imp.RoleRepositoryImpl;
import com.sokheang.mini.services.RoleService;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	private RoleRepositoryImpl roleRepositoryImpl;
	
	@Autowired
	public RoleServiceImpl(@Qualifier("roleRepositoryImpl") RoleRepositoryImpl roleRepositoryImpl) {
		this.roleRepositoryImpl=roleRepositoryImpl;
	}
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepositoryImpl.getAllRole();
	}

	@Override
	public boolean addRole(Role role) {
		return roleRepositoryImpl.addRole(role);
	}

}

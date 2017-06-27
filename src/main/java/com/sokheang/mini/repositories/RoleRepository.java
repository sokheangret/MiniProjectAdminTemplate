package com.sokheang.mini.repositories;

import java.util.List;

import com.sokheang.mini.model.Role;

public interface RoleRepository {
	
	public List<Role> getAllRole();
	public boolean addRole(Role role);
}
package com.sokheang.mini.services;

import java.util.List;

import com.sokheang.mini.model.Role;

public interface RoleService {
	public List<Role> getAllRole();
	public boolean addRole(Role role);
}

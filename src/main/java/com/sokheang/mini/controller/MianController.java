package com.sokheang.mini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sokheang.mini.model.Role;
import com.sokheang.mini.model.User;
import com.sokheang.mini.services.impl.RoleServiceImpl;
import com.sokheang.mini.services.impl.UserServiceImpl;

@Controller
public class MianController {
	
	private UserServiceImpl userServiceImpl;
	private RoleServiceImpl roleServiceImpl;
	
	@Autowired
	public MianController(@Qualifier("userServiceImpl") UserServiceImpl userServiceImpl,@Qualifier("roleServiceImpl") RoleServiceImpl roleServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
		this.roleServiceImpl = roleServiceImpl;
	}
	
	@RequestMapping({"/","/dashboard"})
	public String dashboardPage(ModelMap model){
		model.put("MYTITLE", "Dashboard");
		model.put("URL", "/");
		model.put("ACT","active");
		return "dashboard";
	}
	
	
	
	@RequestMapping("/user-cu")
	public String userCuPage(ModelMap model){
		model.put("MYTITLE", "Dashboard -> Create User");
		model.put("URL", "/user-cu");
		model.addAttribute("user", new User());
		model.put("ACT","active");
		return "user-cu";
	}
	
	@PostMapping("/adduser")
	public String saveUser(@ModelAttribute("user") User user){
		System.out.println(user.getId() + user.getName());
		userServiceImpl.addUser(user);
		return "redirect:/user-list";
	}
	
	@RequestMapping("/user-list")
	public String  userListPage(ModelMap model){
		model.put("MYTITLE", "Dashboard -> User List");
		model.put("URL", "/user-list");
		model.addAttribute("USERS",userServiceImpl.getAllUser());
		model.put("ACT","active");
		return "user-list";
	}
	
	@RequestMapping("/role-cu")
	public String roleCuPage(ModelMap model){
		model.put("MYTITLE", "Dashboard -> Create Role");
		model.put("URL", "/role-cu");
		model.addAttribute("role",new Role());
		model.put("ACT","active");
		return "role-cu";
	}
	
	@PostMapping("/addrole")
	public String saveRole(@ModelAttribute("role") Role role){
		System.out.println(role.getRole_id() + role.getRole_type());
		roleServiceImpl.addRole(role);
		return "redirect:/role-list";
	}
	
	@RequestMapping("/role-list")
	public String roleListPage(ModelMap model){
		model.put("MYTITLE", "Dashboard -> Role List");
		model.put("URL", "/role-list");
		model.addAttribute("ROLES",roleServiceImpl.getAllRole());
		model.put("ACT","active");
		return "role-list";
	}
}

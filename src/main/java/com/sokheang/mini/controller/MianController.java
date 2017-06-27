package com.sokheang.mini.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.put("TOTALUSERS", userServiceImpl.countUser());
		model.put("TOTALMALE", userServiceImpl.countMale());
		model.put("TOTALFEMALE", userServiceImpl.countFemale());
		model.put("TOTALACTIVE", userServiceImpl.countActive());
		return "dashboard";
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
	
	@RequestMapping("/user-list")
	public String userListPage(ModelMap model){
		model.put("MYTITLE", "Dashboard -> User List");
		model.put("URL", "/user-list");
		model.addAttribute("USERS",userServiceImpl.getAllUser());
		model.put("ACT","active");
		return "user-list";
	}
	
	@RequestMapping("/user-profile/{user_hash}")
	public String userProfilePage(ModelMap model,@PathVariable("user_hash") String userHash){
		model.put("MYTITLE", "Dashboard -> User List -> User Profile");
		model.addAttribute("USER",userServiceImpl.getUserProfile(userHash));
		return "user-profile";
	}
	
	@RequestMapping("/user-cu")
	public String userCuPage(ModelMap model){
		model.put("MYTITLE", "Dashboard -> Create User");
		model.put("URL", "/user-cu");
		model.addAttribute("user", new User());
		return "user-cu";
	}
	
	@PostMapping("/adduser")
	public String save(@ModelAttribute("user") User user){
		userServiceImpl.addUser(user);
		return "redirect:/user-list";
	}
	
	@RequestMapping("/user/delete/{user_hash}")
	public String delete(@PathVariable("user_hash") String userHash,ModelMap model){
		userServiceImpl.deleteByUserHash(userHash);
		return "redirect:/user-list";
	}
	
	@PostMapping("/update-profile")
	public String update(@ModelAttribute("user") User user){
		user.setUser_hash(userHash);
		userServiceImpl.updateByUserHash(user);
		return "redirect:/user-list";
	}
	
	String userHash="";
	
	@RequestMapping("/user-profile/update/{user_hash}")
	public String userProfileUpdate(ModelMap model,@PathVariable("user_hash") String userHash){
		model.put("MYTITLE", "Dashboard -> User List -> User Update");
		model.addAttribute("user",userServiceImpl.getUserProfile(userHash));
		model.addAttribute("HASH",userHash);
		System.out.println(userHash);
		this.userHash = userHash;
		return "user-update";
	}
}

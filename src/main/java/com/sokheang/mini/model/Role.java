package com.sokheang.mini.model;

public class Role {
	private int role_id;
	private String role_type;
	public Role(int role_id, String role_type) {
		super();
		this.role_id = role_id;
		this.role_type = role_type;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	
	
}

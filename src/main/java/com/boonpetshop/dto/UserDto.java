package com.boonpetshop.dto;

public class UserDto {
	/* properties */
	private int id;
	private String email;
	private String password;
	private String fullname;
	private int roleId;
	private String roleName;
	
	/* constructors */
	public UserDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public UserDto() {};
	
	/* getters/setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

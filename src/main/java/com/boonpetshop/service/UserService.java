package com.boonpetshop.service;

import java.util.List;

import com.boonpetshop.dto.UserDto;

public interface UserService {
	public List<UserDto> getAll();
	public void insert(UserDto dto);
	public UserDto findById(int id);
	public void update(UserDto dto);
	public void delete(int id);
}

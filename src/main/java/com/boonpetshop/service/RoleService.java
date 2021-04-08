package com.boonpetshop.service;

import java.util.List;

import com.boonpetshop.dto.RoleDto;

public interface RoleService {
	public List<RoleDto> getAll();
	public void insert(RoleDto dto);
	public RoleDto findById(int id);
	public void update(RoleDto dto);
	public void delete(int id);
}

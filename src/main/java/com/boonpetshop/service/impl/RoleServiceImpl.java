package com.boonpetshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boonpetshop.dto.RoleDto;
import com.boonpetshop.entity.Role;
import com.boonpetshop.repository.RoleRepository;
import com.boonpetshop.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<RoleDto> getAll() {
		List<Role> entities = roleRepository.findAll();
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		
		for (Role entity : entities) {
			RoleDto dto = new RoleDto();
			
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setDescription(entity.getDescription());
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public void insert(RoleDto dto) {
		Role entity = new Role();
		
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		roleRepository.save(entity);
	}

	@Override
	public RoleDto findById(int id) {
		RoleDto dto = new RoleDto();
		Optional<Role> optinalEntity = roleRepository.findById(id);
		Role entity = optinalEntity.get();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		
		return dto;
	}

	@Override
	public void update(RoleDto dto) {
		Optional<Role> optinalEntity = roleRepository.findById(dto.getId());
		Role entity = optinalEntity.get();
		
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		roleRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		roleRepository.deleteById(id);
	}
	
}

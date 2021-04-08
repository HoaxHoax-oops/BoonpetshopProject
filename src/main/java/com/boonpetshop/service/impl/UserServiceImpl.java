package com.boonpetshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.boonpetshop.dto.UserDto;
import com.boonpetshop.entity.User;
import com.boonpetshop.repository.UserRepository;
import com.boonpetshop.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> getAll() {
		List<User> entities = userRepository.findAll();
		List<UserDto> dtos = new ArrayList<UserDto>();
		
		for (User entity : entities) {
			UserDto dto = new UserDto();
			
			dto.setId(entity.getId());
			dto.setEmail(entity.getEmail());
			dto.setPassword(entity.getPassword());
			dto.setFullname(entity.getFullname());
			dto.setRoleId(entity.getRoleId());
			dto.setRoleName(entity.getRole().getName());
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public void insert(UserDto dto) {
		User entity = new User();
		String hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		
		entity.setEmail(dto.getEmail());
		entity.setPassword(hashedPassword);
		entity.setFullname(dto.getFullname());
		entity.setRoleId(dto.getRoleId());
		
		userRepository.save(entity);
	}

	@Override
	public UserDto findById(int id) {
		UserDto dto = new UserDto();
		Optional<User> optinalEntity = userRepository.findById(id);
		User entity = optinalEntity.get();
		
		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setFullname(entity.getFullname());
		dto.setRoleId(entity.getRoleId());
		dto.setRoleName(entity.getRole().getName());
		
		return dto;
	}

	@Override
	public void update(UserDto dto) {
		Optional<User> optinalEntity = userRepository.findById(dto.getId());
		User entity = optinalEntity.get();
		String hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		
		entity.setEmail(dto.getEmail());
		entity.setPassword(hashedPassword);
		entity.setFullname(dto.getFullname());
		entity.setRoleId(dto.getRoleId());
		
		userRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}

package com.boonpetshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boonpetshop.dto.UserDetailsDto;
import com.boonpetshop.entity.User;
import com.boonpetshop.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null) throw new UsernameNotFoundException("Invalid username!");
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String roleName = user.getRole().getName();
		authorities.add(new SimpleGrantedAuthority(roleName));
		
		return new UserDetailsDto(user.getEmail(), user.getPassword(), authorities);
	}

}

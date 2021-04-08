package com.boonpetshop.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/login")
public class AdminLoginController {
	private AuthenticationManager authenticationManager;
	
	public AdminLoginController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public Object post() {
		try {
			return new ResponseEntity<Object>(authService.login(loginDto), HttpStatus.OK);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}

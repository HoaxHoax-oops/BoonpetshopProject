package com.boonpetshop.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boonpetshop.dto.UserDto;
import com.boonpetshop.service.UserService;

@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {
	private UserService userService;
	
	public AdminUserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "")
	public Object get() {
		try {
			List<UserDto> dtos = userService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/post")
	public Object post(@RequestBody UserDto dto) {
		try {
			userService.insert(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/{id}")
	public Object get(@PathVariable("id") Integer id) {
		try {
			UserDto dto = userService.findById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value = "/put")
	public Object put(@RequestBody UserDto dto) {
		try {
			userService.update(dto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public Object delete(@PathVariable("id") Integer id) {
		try {
			userService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}

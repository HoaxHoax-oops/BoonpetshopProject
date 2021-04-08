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

import com.boonpetshop.dto.RoleDto;
import com.boonpetshop.service.RoleService;

@RestController
@RequestMapping(value = "/admin/role")
public class AdminRoleController {
	private RoleService roleService;
	
	public AdminRoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping(value = "")
	public Object get() {
		try {
			List<RoleDto> dtos = roleService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/post")
	public Object post(@RequestBody RoleDto dto) {
		try {
			roleService.insert(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/{id}")
	public Object get(@PathVariable("id") Integer id) {
		try {
			RoleDto dto = roleService.findById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value = "/put")
	public Object put(@RequestBody RoleDto dto) {
		try {
			roleService.update(dto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public Object delete(@PathVariable("id") Integer id) {
		try {
			roleService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}

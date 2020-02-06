package com.situ.layoa.role.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleService roleService;

	@PostMapping
	public Long doAddAddress(Role role) {
		return roleService.save(role);
	}

	@GetMapping("/checkname")
	public Integer checkname(Role role) {
		int a = 0;
		List<Role> roleList = roleService.findAll();
		for (Role rol : roleList) {
			if (role.getRoleName().equals(rol.getRoleName())) {
				a = 1;
			}
		}
		return a;
	}
}

package com.situ.layoa.role.service;

import java.util.List;

import com.situ.layoa.role.domain.Role;

public interface RoleService {
	
	Long save(Role role);

	List<Role> findAll();
}

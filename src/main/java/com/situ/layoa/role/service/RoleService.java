package com.situ.layoa.role.service;

import java.util.List;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.domain.RoleLayResult;

public interface RoleService {
	
	Long save(Role role);
	
	List<Role> findAll();

	RoleLayResult findAll(Integer page,Integer limit,String roleCode);
	
	Long delete(Long rowId);
	
	Role getById(Long rowId);
	
	Long update(Role role);
}

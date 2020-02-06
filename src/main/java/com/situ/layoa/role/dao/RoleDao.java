package com.situ.layoa.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.student.domain.Student;

@Repository
public interface RoleDao {

	Long save(Role role);

	List<Role> findAll();
	
}

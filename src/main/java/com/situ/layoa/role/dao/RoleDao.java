package com.situ.layoa.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.layoa.role.domain.Role;

@Repository
public interface RoleDao {

	Long save(Role role);
	
	List<Role> findAll();

	List<Role> find(@Param("firstResult") Integer firstResult,@Param("limit")Integer limit,@Param("roleCode")String roleCode);
	
	Integer getCount();
	
	void delete(Long rowId);
	
	Role getById(Long rowId);
	
	Long update(Role role);
}

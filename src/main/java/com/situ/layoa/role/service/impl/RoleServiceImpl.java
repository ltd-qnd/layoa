package com.situ.layoa.role.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.role.dao.RoleDao;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	// 新增
	@Override
	public Long save(Role role) {
		role.setActiveFlag(1);
		role.setCreateBy("manage");
		role.setCreateDate(new Date());
		return roleDao.save(role);
	}

	// 查询所有
	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

}

package com.situ.layoa.role.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.role.dao.RoleDao;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.domain.RoleLayResult;
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
	public RoleLayResult findAll(Integer page,Integer limit,String roleCode) {
		//查询出数据总数
		Integer count = roleDao.getCount();
		//limit查询数据开始的下标
		Integer firstResult = (page-1)*limit;
		
		List<Role> roleList = roleDao.find(firstResult,limit,roleCode);
		return new RoleLayResult(0, "", count, roleList);
	}

	//删除
	@Override
	public Long delete(Long rowId) {
		roleDao.delete(rowId);
		return 1L;
	}

	//进修改
	@Override
	public Role getById(Long rowId) {
		return roleDao.getById(rowId);
	}

	//修改
	@Override
	public Long update(Role role) {
		role.setUpdateBy("user");
		role.setUpdateDate(new Date());
		roleDao.update(role);
		return 1L;
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

}

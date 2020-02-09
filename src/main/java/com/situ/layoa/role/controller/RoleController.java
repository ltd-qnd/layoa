package com.situ.layoa.role.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;
import com.situ.layoa.role.domain.RoleLayResult;

@RestController
@RequestMapping("/role")
public class RoleController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String GO_ROLE_ADD = "role-add";

	@Autowired
	private RoleService roleService;

	// 进新增
	@GetMapping("/goadd")
	public ModelAndView goAdd(ModelAndView modelAndView) {
		modelAndView.setViewName(GO_ROLE_ADD);
		return modelAndView;
	}

	// 新增
	@PostMapping
	public Long doAddAddress(Role role) {
		return roleService.save(role);
	}

	// 进修改
	@GetMapping("/{rowId}")
	public Role goUpdate(@PathVariable Long rowId) {
		return roleService.getById(rowId);
	}
	
	//修改
	@PutMapping
	public Long doUpdate(Role role) {
		return roleService.update(role);
	}

	// 姓名重复校验
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

	// 表格查询
	@ResponseBody
	@RequestMapping("/{page}/{limit}")
	public RoleLayResult findAllRole(@PathVariable Integer page,@PathVariable Integer limit,String roleCode) {
		return roleService.findAll(page, limit, roleCode);
	}

	// 删除
	@DeleteMapping("/{rowId}")
	public Long delete(@PathVariable Long rowId) {
		return roleService.delete(rowId);
	}
}

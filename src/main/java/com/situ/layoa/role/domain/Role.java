package com.situ.layoa.role.domain;

import java.io.Serializable;

import com.situ.layoa.base.domain.BaseClass;

public class Role extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String roleCode;// 角色编号
	private String roleName;// 角色名称（唯一）
	private Integer roleKind;// 角色类型：1 一级角色 0 二级角色
	private String roleInfo;// 角色简介

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleKind() {
		return roleKind;
	}

	public void setRoleKind(Integer roleKind) {
		this.roleKind = roleKind;
	}

	public String getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}

}

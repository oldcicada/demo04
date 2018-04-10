package com.cicada.service;

import java.util.List;

import com.cicada.entity.Role;

public interface RoleService {
	/* 
	 * 获得系统所有角色信息
	*/
	public List<Role> getRoleList();
}

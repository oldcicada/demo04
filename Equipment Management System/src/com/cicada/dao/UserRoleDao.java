package com.cicada.dao;

import com.cicada.entity.UserRole;

public interface UserRoleDao {
	//根据用户id获得角色id
	int getRoleIdByUserId(int user_id);
	//根据用户id删除角色id
	public void deleteByRoleId(int id);
	//添加记录
	public void add(UserRole userRole);
}

package com.cicada.service;

public interface UserRoleService {
	//根据用户id获得角色id
	int getRoleIdByUserId(int user_id);
	//根据用户id删除角色id
	void deleteByRoleId(int id);
	//添加记录
	void add(int userId, int roleId);
}

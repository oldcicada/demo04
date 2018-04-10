package com.cicada.dao;

public interface UserRoleDao {
	//根据用户id获得角色id
	int getRoleIdByUserId(int user_id);
}

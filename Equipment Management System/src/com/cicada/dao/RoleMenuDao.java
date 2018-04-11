package com.cicada.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMenuDao {
	//根据RoleId删除记录
	void deleteByRoleId(int id);
	//根据RoleId获取对应的菜单项id
	List<Integer> getMenuListById(int id);
	//添加数据
	void add(@Param("role_id")int role_id,@Param("menu_id")int menu_id);
}

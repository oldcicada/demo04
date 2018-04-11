package com.cicada.service;

import java.util.List;

import com.cicada.common.MenuTreeDto;

public interface RoleMenuService {
	//根据RoleId删除记录
	void deleteByRoleId(int id);
	//根据RoleId获取对应的菜单项id
	public List<Integer> getMenuListById(int id);
	//根据RoleId生成对应菜单树
	public List<MenuTreeDto> getMenuTree(int id);
	//生成菜单树(用于添加角色)
	public List<MenuTreeDto> getAllMenuTree();
	//添加数据
	void add(int id, int[] menuId);
}

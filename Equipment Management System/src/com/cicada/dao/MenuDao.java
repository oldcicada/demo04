package com.cicada.dao;

import java.util.List;

import com.cicada.entity.Menu;

public interface MenuDao {
	//获取用户菜单列表
	public List<Menu> getMenuList(int id);
	//获取所有菜单列表
	public List<Menu> getAllMenuList();
}

package com.cicada.service;

import java.util.List;

import com.cicada.entity.Menu;

public interface MenuService {
	//获取用户菜单列表
	public List<Menu> getMenuList(int id);
}

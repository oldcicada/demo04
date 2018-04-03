package com.cicada.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.MenuDao;
import com.cicada.entity.Menu;
import com.cicada.service.MenuService;
import com.cicada.util.SqlSessionFactoryUtil;

public class MenuServiceImpl implements MenuService{
	private SqlSession sqlSession = null;
	private MenuDao md = null;
	public List<Menu> getMenuList(int id) {
		sqlSession=SqlSessionFactoryUtil.getSqlSession();
		md = sqlSession.getMapper(MenuDao.class);
		List<Menu> menuList = md.getMenuList(id);
		List<Menu> list=new ArrayList<Menu>();
		list=findChildren(menuList,0);
		sqlSession.close();
		return list;
	}
	private List<Menu>  findChildren(List<Menu> menuList,int pid ) {
		List<Menu> list=new ArrayList<Menu>();
		if(menuList != null){
			for (Menu menu : list) {
				if(menu.getParent_menu().equals(pid+"")){
					List<Menu> children=findChildren(list,menu.getId());
					menu.setMenus(children);
					list.add(menu);
				}
			}
		}
		return list;
	}
	
}

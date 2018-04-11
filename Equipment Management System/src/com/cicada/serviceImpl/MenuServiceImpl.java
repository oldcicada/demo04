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
	//根据id查询用户的菜单列表
	public List<Menu> getMenuList(int id) {
		sqlSession=SqlSessionFactoryUtil.getSqlSession();
		md = sqlSession.getMapper(MenuDao.class);
		List<Menu> menuList = md.getMenuList(id);
		List<Menu> list=new ArrayList<Menu>();
		list=findChildren(menuList,0);
		sqlSession.close();
		return list;
	}
	//递归查找子菜单
	private List<Menu>  findChildren(List<Menu> menuList,int pid ) {
		List<Menu> list=new ArrayList<Menu>();
		if(menuList != null){
			for (Menu menu : menuList){
				if(menu.getParent_menu().equals(pid+"")){
					List<Menu> children=findChildren(menuList,menu.getId());
					menu.setMenus(children);
					//System.out.println(menu.getName()+"  容量："+menu.getMenus().size());
					list.add(menu);
				}
			}
		}
		return list;
	}
	//获取所有菜单列表
		public List<Menu> getAllMenuList() {
		sqlSession=SqlSessionFactoryUtil.getSqlSession();
		md = sqlSession.getMapper(MenuDao.class);
		List<Menu> menuList = md.getAllMenuList();
		return menuList;
	}
}

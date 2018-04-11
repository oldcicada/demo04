package com.cicada.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cicada.common.MenuTreeDto;
import com.cicada.dao.RoleMenuDao;
import com.cicada.entity.Menu;
import com.cicada.service.MenuService;
import com.cicada.service.RoleMenuService;
import com.cicada.util.SqlSessionFactoryUtil;

public class RoleMenuServiceImpl implements RoleMenuService {
	//根据RoleId删除记录
	private SqlSession sqlSession =null;
	private RoleMenuDao rmd =null; 
		public void deleteByRoleId(int id) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rmd = sqlSession.getMapper(RoleMenuDao.class);
			rmd.deleteByRoleId(id);
			sqlSession.commit();
			sqlSession.close();
		}
		//根据RoleId获取对应的菜单项id
		public List<Integer> getMenuListById(int id){
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rmd = sqlSession.getMapper(RoleMenuDao.class);
			List<Integer> list = rmd.getMenuListById(id);
			return list;
		}
		//根据RoleId生成对应菜单树
		public List<MenuTreeDto> getMenuTree(int id){
			//1、查询所有栏目
			MenuService ms=new MenuServiceImpl();
			List<Menu> allMenuList = ms.getAllMenuList();
			
			//2、根据角色id查询栏目
			List<Integer> menuListId = getMenuListById(id);
			Map<Integer,Integer> menuListIdMap=new HashMap<>();
			for (Integer menuId : menuListId) {
				menuListIdMap.put(menuId, menuId);
			}
			//保存MenuTreeDto对象
			List<MenuTreeDto> tree=new ArrayList<MenuTreeDto>();
			for (Menu menu : allMenuList) {
				boolean checked=false;
				if(menuListIdMap.containsKey(menu.getId())) {
					 checked=true;//设置为true表示选中
				}
				MenuTreeDto dto=new MenuTreeDto(menu.getId(),Integer.parseInt(menu.getParent_menu()) ,menu.getName(),false, checked);
				tree.add(dto);
				}
			return tree;
		}
		//生成菜单树(用于添加角色)
		public List<MenuTreeDto> getAllMenuTree(){
			//1、查询所有栏目
			MenuService ms=new MenuServiceImpl();
			List<Menu> allMenuList = ms.getAllMenuList();
			
			//保存MenuTreeDto对象
			List<MenuTreeDto> tree=new ArrayList<MenuTreeDto>();
			for (Menu menu : allMenuList) {
				MenuTreeDto dto=new MenuTreeDto(menu.getId(),Integer.parseInt(menu.getParent_menu()) ,menu.getName(),false, false);
				tree.add(dto);
				}
			return tree;
		}
		//添加数据
		public void add(int id, int[] menuId) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rmd = sqlSession.getMapper(RoleMenuDao.class);
			for (int i : menuId) {
				rmd.add(id,i);
			}
			sqlSession.commit();
			sqlSession.close();
		}
}

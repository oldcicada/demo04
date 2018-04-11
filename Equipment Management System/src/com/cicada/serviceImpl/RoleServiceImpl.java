package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.RoleDao;
import com.cicada.entity.Role;
import com.cicada.service.RoleService;
import com.cicada.util.SqlSessionFactoryUtil;

public class RoleServiceImpl implements RoleService {
	private SqlSession sqlSession =null;
	private RoleDao rd=null;
	 //获得系统所有角色信息
		public List<Role> getRoleList(){
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RoleDao.class);
			List<Role> roleList = rd.getRoleList();
			sqlSession.close();
			return roleList;
		}
		// 获得系统所有角色信息用于分页
		public List<Role> getPageRoleList(String name,int pageIndex,int pageSize){
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("start", (pageIndex - 1) * pageSize);
			map.put("end", pageSize);
			map.put("name", "%" + name + "%");
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RoleDao.class);
			List<Role> roleList = rd.getPageRoleList(map);
			sqlSession.close();
			return roleList;
		}
		//根据id删除角色
		public void deleteByRoleId(int id) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RoleDao.class);
			rd.deleteByRoleId(id);
			sqlSession.commit();
			sqlSession.close();
		}
		//根据id查找角色
		public Role getRoleById(int id) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RoleDao.class);
			Role role = rd.getRoleById(id);
			sqlSession.close();
			return role;
		}
		//根据id更新角色信息
		public void updateByIdMessage(Role role) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RoleDao.class);
			rd.updateByIdMessage(role);
			sqlSession.commit();
			sqlSession.close();
		}
		//添加角色信息
		public void addRoleMessage(Role role) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RoleDao.class);
			rd.addRoleMessage(role);
			sqlSession.commit();
			sqlSession.close();
		}
		//根据code获得id
		public int getRoleIdByCode(String code) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RoleDao.class);
			int roleId = rd.getRoleIdByCode(code);
			sqlSession.close();
			return roleId;
		}
}

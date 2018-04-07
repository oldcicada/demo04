package com.cicada.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.RoleDao;
import com.cicada.entity.Role;
import com.cicada.service.RoleService;
import com.cicada.util.SqlSessionFactoryUtil;

public class RoleServiceImpl implements RoleService {
	/* 
	 * 获得系统所有角色信息
	*/
		public List<Role> getRoleList(){
			SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
			RoleDao rd = sqlSession.getMapper(RoleDao.class);
			List<Role> roleList = rd.getRoleList();
			sqlSession.close();
			return roleList;
		}
		
}

package com.oldcicada.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cicada.dao.RoleDao;
import com.cicada.util.SqlSessionFactoryUtil;

public class RoleDaoTest {

	@Test
	public void getRoleNameTest() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		RoleDao rd = sqlSession.getMapper(RoleDao.class);
	}
}

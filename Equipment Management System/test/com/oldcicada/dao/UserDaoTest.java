package com.oldcicada.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cicada.dao.UserDao;
import com.cicada.entity.User;
import com.cicada.util.SqlSessionFactoryUtil;

public class UserDaoTest {

	@Test
	public void testLogin() {
		SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession();
		UserDao ud=sqlSession.getMapper(UserDao.class);
		User user = ud.login("admin", "123456");
		System.out.println(user.getPassword());
	}
}

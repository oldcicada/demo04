package com.oldcicada.dao;

import java.util.List;

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
		int loginResault = ud.login("admin", "123456");
		System.out.println(loginResault);
	}
	@Test
	public void getUserMessage() {
		SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession();
		UserDao ud=sqlSession.getMapper(UserDao.class);
		User loginResault = ud.getUserMessage(1);
		System.out.println(loginResault.getUsername());
	}
	@Test
	public void getAllUserMessage() {
		SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession();
		UserDao ud=sqlSession.getMapper(UserDao.class);
		List<User> loginResault = ud.getAllUserMessage();
		System.out.println(loginResault.size());
	}

}

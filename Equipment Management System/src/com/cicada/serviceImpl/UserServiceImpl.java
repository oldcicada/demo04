package com.cicada.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.UserDao;
import com.cicada.entity.User;
import com.cicada.service.UserService;
import com.cicada.util.SqlSessionFactoryUtil;

public class UserServiceImpl implements UserService {
	private SqlSession sqlSession = null;
	private UserDao ud = null;

	// 登录获取用户id
	public User login(String loginName, String password) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		User user = ud.login(loginName, password);
		sqlSession.close();
		return user;
	}

	// 获取所有用户信息
	public List<User> getAllUser() {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		List<User> userlist = ud.getAllUser();
		sqlSession.close();
		return userlist;
	}

	// 登陆成功，修改最后登录时间和登录IP地址
	public void updateLoginMessage(String login_ip,int id){
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		ud.updateLoginMessage(login_ip, id);
		sqlSession.close();
	}
}

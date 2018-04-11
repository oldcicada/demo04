package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cicada.common.DictionaryUtil;
import com.cicada.common.PageDto;
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
	//获取用户id
		public int getUserId(String login_name, String password) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			ud = sqlSession.getMapper(UserDao.class);
			int userId = ud.getUserId(login_name, password);
			sqlSession.close();
			return userId;
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
	public void updateLoginMessage(String login_ip, int id) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		ud.updateLoginMessage(login_ip, id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 分页查询用户列表
	public PageDto<User> queryUserPage(int pageIndex, int pageSize, String login_name, String name) {
		PageDto<User> pageDto = new PageDto<User>();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("start", (pageIndex - 1) * pageSize);
		map.put("end", pageSize);
		map.put("login_name", "%" + login_name + "%");
		map.put("name", "%" + name + "%");

		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		List<User> userList = ud.queryUserPage(map);
		// System.out.println(userList.size());
		// 根据数据字典得到性别value
		
		 for (User user : userList) { 
			  user.setSex(DictionaryUtil.queryDictionaryName("sex",user.getSex()));
		  }

		pageDto.setPageIndex(pageIndex);
		pageDto.setPageSize(pageSize);
		pageDto.setList(userList);
		int count = ud.queryUserCount(map);
		// System.out.println(count);
		pageDto.setCount(count);
		pageDto.setPageTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);

		sqlSession.close();
		return pageDto;
	}

	// 根据id删除用户信息
	public void deleteUserById(int id) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		ud.deleteUserById(id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 根据用户id获得用户信息
	public User getUserById(int id) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		User user = ud.getUserById(id);
		sqlSession.close();
		return user;
	}

	// 修改用户信息
	public void UpdateUserMessage(User user) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		ud.UpdateUserMessage(user);
		sqlSession.commit();
		sqlSession.close();
	}

	//重置密码
		public void resetPass(int id) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ud = sqlSession.getMapper(UserDao.class);
		ud.resetPass(id);
		sqlSession.commit();
		sqlSession.close();
	}
		//添加用户
		public void addUserMessage(User user) {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			ud = sqlSession.getMapper(UserDao.class);
			ud.addUserMessage(user);
			sqlSession.commit();
			sqlSession.close();
		}
}

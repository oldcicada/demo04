package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

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
		sqlSession.commit();
		sqlSession.close();
	}

	//分页查询用户列表
	public PageDto<User> queryUserPage(int pageIndex, int pageSize, String login_name, String name) {
		PageDto<User> pageDto=new PageDto<User>();
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("start", (pageIndex-1)*pageSize);
		map.put("end", pageIndex*pageSize);
		map.put("login_name", "%"+login_name+"%");
		map.put("name", "%"+name+"%");
		
		SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
		UserDao ud=sqlSession.getMapper(UserDao.class);
		List<User>  userList=ud.queryUserPage(map);
		//System.out.println(userList.size());
		//根据数据字典得到性别value
		/*for (User user : userList) {
			user.setSexValue(DictUtil.queryDictName("sex", user.getSex()));
		}*/
		
		pageDto.setPageIndex(pageIndex);
		pageDto.setPageSize(pageSize);
		pageDto.setList(userList);
		int count=ud.queryUserCount(map);
		//System.out.println(count);
		pageDto.setCount(count);
		pageDto.setPageTotal(count%pageSize ==0?count/pageSize:count/pageSize+1);
		
		sqlSession.close();
		return pageDto;
	}
	
}

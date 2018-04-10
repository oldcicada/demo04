package com.cicada.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.UserRoleDao;
import com.cicada.service.UserRoleService;
import com.cicada.util.SqlSessionFactoryUtil;

public class UserRoleServiceImpl implements UserRoleService {
	//根据用户id获得角色id
	public int getRoleIdByUserId(int user_id){
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserRoleDao urd = sqlSession.getMapper(UserRoleDao.class);
		int userId = -1;
				try {
					userId = urd.getRoleIdByUserId(user_id);
				} catch (Exception e) {
					System.out.println(e);
				}finally {
					sqlSession.close();
				}
		return userId;
		}
}

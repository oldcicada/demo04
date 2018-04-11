package com.cicada.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.UserRoleDao;
import com.cicada.entity.UserRole;
import com.cicada.service.UserRoleService;
import com.cicada.util.SqlSessionFactoryUtil;

public class UserRoleServiceImpl implements UserRoleService {
	private SqlSession sqlSession=null;
	private UserRoleDao urd = null;
	//根据用户id获得角色id
	public int getRoleIdByUserId(int user_id){
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		urd = sqlSession.getMapper(UserRoleDao.class);
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

	//根据用户id删除角色id
	public void deleteByRoleId(int id) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		urd = sqlSession.getMapper(UserRoleDao.class);
		urd.deleteByRoleId(id);
		sqlSession.commit();
		sqlSession.close();
	}
	//添加记录
	public void add(int user_id, int role_id) {
		UserRole userRole=new UserRole(user_id, role_id);
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		urd = sqlSession.getMapper(UserRoleDao.class);
		urd.add(userRole);
		sqlSession.commit();
		sqlSession.close();
		}
}

package com.cicada.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cicada.common.BaseDao;
import com.cicada.entity.User;

public class UserDao extends BaseDao {
	private QueryRunner runner = new BaseDao().getRunner();

	// login
	public int login(String username, String password) {
		int userid = -1;
		String sql = "select id from user where username=? and password=?";
		Object[] params = { username, password };
		try {
			userid= runner.query(sql, new ScalarHandler<Integer>(), params);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
		}
		return userid;
	}

	// 获取user信息
	public User getUserMessage(int userid) {
		User user = null;
		String sql = "select * from user where id=?";
		int param = userid;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), param);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	// 获取userList信息
		public List<User> getAllUserMessage() {
			List<User> list=new ArrayList<User>();
			String sql = "select username,nickname,email,sex from user";
			try {
				list = runner.query(sql, new BeanListHandler<User>(User.class));
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return list;
		}
		// 获取userList信息
		public List<User> queryAllUserMessage(String username,String nickname) {
		List<User> list = new ArrayList<User>();
		String sql = "select username,nickname,email,sex from user where username=? or nickname=?";
		Object[] params= {username,nickname};
		try {
			list = runner.query(sql, new BeanListHandler<User>(User.class),params);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					return list;
				}
}

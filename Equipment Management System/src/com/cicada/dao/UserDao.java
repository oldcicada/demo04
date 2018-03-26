package com.cicada.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
	public User getUser(int userid) {
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
}

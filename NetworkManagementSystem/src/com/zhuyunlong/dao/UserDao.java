package com.zhuyunlong.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zhuyunlong.pojo.User;
import com.zhuyunlong.util.JdbcUtil;

public class UserDao {
	private QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
public User getUser(String number,String password) {
	String sql="select * from user where number=? and password=?";
	Object params[]= {number,password};
	User user=null;
	try {
		user=runner.query(sql,new BeanHandler<User>(User.class), params);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
}
public void add(User user) {
	String sql="insert into user(name,password,number) value(?,?,?)";
	Object params[]= {user.getName(),user.getPassword(),user.getNumber()};
	try {
		runner.update(sql, params);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}

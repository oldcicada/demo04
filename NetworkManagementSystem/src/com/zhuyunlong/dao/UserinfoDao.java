package com.zhuyunlong.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhuyunlong.pojo.Userinfo;
import com.zhuyunlong.util.JdbcUtil;

public class UserinfoDao {
	private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());

	public Userinfo getUser(String number) {
		String sql = "select * from userinfo where number=?";
		Object params[] = { number };
		Userinfo userinfo = null;
		try {
			userinfo = runner.query(sql, new BeanHandler<Userinfo>(Userinfo.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userinfo;
	}

	public int getRoomnumber(String number) {
		String sql = "select roomnumber from userinfo where number=?";
		Object params[] = { number };
		int roomnumber=0;
		try {
			roomnumber = runner.query(sql, new ScalarHandler<Integer>(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomnumber;
	}
	public void add(String number,String email,int sex,int roomnumber) {
		String sql = "insert into userinfo(number,state,email,sex,roomnumber) value(?,1,?,?,?)";
		Object params[] = { number,email,sex,roomnumber };
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Userinfo> getRoomList() {
		String sql = "select * from userinfo";
		List<Userinfo> list = new ArrayList<>();
		try {
			list = runner.query(sql, new BeanListHandler<Userinfo>(Userinfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

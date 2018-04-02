package com.cicada.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cicada.entity.User;

public interface UserDao {
	// 登录获取用户id
	public User login(@Param("login_name") String loginName, @Param("password") String password);
	//获取所有用户信息
	public List<User> getAllUser();
}

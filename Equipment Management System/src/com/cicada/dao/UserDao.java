package com.cicada.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cicada.entity.User;

public interface UserDao {
	// 登录获取用户id
	public User login(@Param("username") String username, @Param("password") String password);

	// 登录获取id=?的用户信息
	public User getUserMessage(int id);

	// 登录获取所有用户信息
	public List<User> getAllUserMessage();

	//根据用户名和昵称查询用户信息
	public List<User> queryAllUserMessage(@Param("username") String username, @Param("nickname") String nickname);
}

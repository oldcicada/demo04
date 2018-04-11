package com.cicada.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cicada.entity.User;

public interface UserDao {
	// 登录获取用户id
	public User login(@Param("login_name") String loginName, @Param("password") String password);
	// 获取用户id
	public int getUserId(@Param("login_name") String login_name, @Param("password") String password);
	//获取所有用户信息
	public List<User> getAllUser();
	//登陆成功，修改最后登录时间和登录IP地址 
	public void updateLoginMessage(@Param("login_ip") String login_ip, @Param("id")int id);
	//分页查询用户列表
	public List<User> queryUserPage(Map<Object, Object> map);
	//查询总数
	public int queryUserCount(Map<Object, Object> map);
	//密码重置
	public void resetPass(int id);
	// 根据id删除用户信息
	public void deleteUserById(int id);
	//根据用户id获得用户信息
	public User getUserById(int id);
	//修改用户信息
	public void UpdateUserMessage(User user);
	//添加用户
	public void addUserMessage(User user); 
}

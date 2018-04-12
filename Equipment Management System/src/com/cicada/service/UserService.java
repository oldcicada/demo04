package com.cicada.service;

import java.util.List;
import com.cicada.common.PageDto;
import com.cicada.entity.User;

public interface UserService {
	//获取用户id
	public int getUserId(String login_name, String password);
	// 登录获取用户id
	public User login(String loginName, String password);
	//获取所有用户信息
	public List<User> getAllUser();
	//登陆成功，修改最后登录时间和登录IP地址 
	public void updateLoginMessage(String login_ip,int id);
	//分页查询用户列表
	public PageDto<User> queryUserPage(int pageIndex, int pageSize, String login_name, String name);
	//根据id删除用户信息
	public void deleteUserById(int id);
	//根据用户id获得用户信息
	public User getUserById(int id);
	//修改用户信息
	public void UpdateUserMessage(User user);
	//重置密码
	public void resetPass(int id);
	//添加用户
	public void addUserMessage(User user);
	//用于邮箱改密码
	public int getUserIdByEmail(String email);
}

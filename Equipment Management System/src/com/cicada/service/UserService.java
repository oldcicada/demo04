package com.cicada.service;

import java.util.List;

import com.cicada.common.PageDto;
import com.cicada.entity.User;

public interface UserService {
	// 登录获取用户id
	public User login(String loginName, String password);
	//获取所有用户信息
	public List<User> getAllUser();
	//登陆成功，修改最后登录时间和登录IP地址 
	public void updateLoginMessage(String login_ip,int id);
	//分页查询用户列表
	public PageDto<User> queryUserPage(int pageIndex, int pageSize, String login_name, String name);
}

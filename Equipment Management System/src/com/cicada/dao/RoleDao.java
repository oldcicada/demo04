package com.cicada.dao;

import java.util.List;
import java.util.Map;

import com.cicada.entity.Role;

public interface RoleDao {

	//获得系统所有角色信息
	public List<Role> getRoleList();
	// 获得系统所有角色信息用于分页
	public List<Role> getPageRoleList(Map<Object, Object> map );
	//根据id删除角色
	public void deleteByRoleId(int id);
	//根据id查找角色
	public Role getRoleById(int id);
	//根据id更新角色信息
	public void updateByIdMessage(Role role);
	//添加角色信息
	public void addRoleMessage(Role role);
	//根据code获得id
	public int getRoleIdByCode(String code);
}

package com.cicada.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cicada.common.BaseDao;

public class RoleDao extends BaseDao{
	private QueryRunner runner=new RoleDao().getRunner();
	//获取角色名
	public String getRole(int userid) {
		String sql="SELECT role.`rolename` FROM USER,role WHERE user.`roleid`=role.`id` AND user.`id`=?";
		int param=userid;
		String rolename="";
		try {
			rolename=runner.query(sql, new ScalarHandler<>(), param);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rolename;
	}
}

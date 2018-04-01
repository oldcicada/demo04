package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class UserRole extends BaseEntity {
	private int userId;
	private int Roleid;

	public UserRole() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleid() {
		return Roleid;
	}

	public void setRoleid(int roleid) {
		Roleid = roleid;
	}
}

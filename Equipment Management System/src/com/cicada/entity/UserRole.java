package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class UserRole extends BaseEntity {
	private int user_id;
	private int role_id;

	public UserRole() {

	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

}

package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class Role extends BaseEntity{
	private String rolename;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}

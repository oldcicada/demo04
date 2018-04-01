package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class Role extends BaseEntity {

	private String roleType;
	private String description;

	public Role() {

	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

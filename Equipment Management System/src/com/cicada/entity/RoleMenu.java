package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class RoleMenu extends BaseEntity {
	private int roid_id;
	private int menu_id;

	public int getRoid_id() {
		return roid_id;
	}


	public void setRoid_id(int roid_id) {
		this.roid_id = roid_id;
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public RoleMenu() {
		
	}
}

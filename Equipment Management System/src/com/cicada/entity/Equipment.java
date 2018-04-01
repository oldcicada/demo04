package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class Equipment extends BaseEntity {
	private String equipmentName;
	private int officeId;

	public Equipment() {

	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
}

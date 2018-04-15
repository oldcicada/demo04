package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class Equipment extends BaseEntity {
	private String name;
	private String code;
	private String type;
	private String remark;
	private String state;
	private int room_id;
	private String deleted;
	//用于存储房间名称
	private String room_name;

	public Equipment() {

	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Equipment(String name, String code, String type, String remark, String state, int room_id) {
		this.name = name;
		this.code = code;
		this.type = type;
		this.remark = remark;
		this.state = state;
		this.room_id = room_id;
	}
	
}

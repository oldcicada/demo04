package com.cicada.entity;

import java.util.Date;

import com.cicada.common.BaseEntity;

public class Repair extends BaseEntity {
	private String number;
	private String title;
	private String description;
	private int room_id;
	private int equipment_id;
	private int send_user_id;
	private Date send_time;
	private String state;
	private int get_user_id;
	private Date get_time;
	private Date done_time;
	private String resule;
	private int money;
	private String deleted;

	public Repair() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getResule() {
		return resule;
	}

	public void setResule(String resule) {
		this.resule = resule;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(int equipment_id) {
		this.equipment_id = equipment_id;
	}

	public int getSend_user_id() {
		return send_user_id;
	}

	public void setSend_user_id(int send_user_id) {
		this.send_user_id = send_user_id;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public int getGet_user_id() {
		return get_user_id;
	}

	public void setGet_user_id(int get_user_id) {
		this.get_user_id = get_user_id;
	}

	public Date getGet_time() {
		return get_time;
	}

	public void setGet_time(Date get_time) {
		this.get_time = get_time;
	}

	public Date getDone_time() {
		return done_time;
	}

	public void setDone_time(Date done_time) {
		this.done_time = done_time;
	}

}

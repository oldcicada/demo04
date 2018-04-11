package com.cicada.entity;

import java.util.Date;

import com.cicada.common.BaseEntity;

public class User extends BaseEntity {
	private String login_name;
	private String name;
	private String password;
	private String number;
	private String sex;
	private String email;
	private String phone;
	private String type;
	private String head_address;
	private String login_ip;
	private Date login_time;
	private String login_state;
	private String founder;
	private Date creation_time;
	private String updater;
	private Date update_time;
	private String description;
	private String deleted;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public User() {

	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getHead_address() {
		return head_address;
	}

	public void setHead_address(String head_address) {
		this.head_address = head_address;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getLogin_state() {
		return login_state;
	}

	public void setLogin_state(String login_state) {
		this.login_state = login_state;
	}

	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	

	public User(String login_name, String name, String password, String number, String sex, String email, String phone,
			String founder, String updater, String description) {
		this.login_name = login_name;
		this.name = name;
		this.password = password;
		this.number = number;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.founder = founder;
		this.updater = updater;
		this.description = description;
	}

	public User(int id,String login_name, String name, String sex, String email, String phone, String updater) {
		this.id=id;
		this.login_name = login_name;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.updater = updater;
	}
}

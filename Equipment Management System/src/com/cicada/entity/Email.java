package com.cicada.entity;

import java.util.Date;

import com.cicada.common.BaseEntity;

public class Email extends BaseEntity {
	private String type;
	private String content;
	private String login_name;
	private Date send_time;
	private Date failuer_time;
	private String state;

	public Email() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public Date getFailuer_time() {
		return failuer_time;
	}

	public void setFailuer_time(Date failuer_time) {
		this.failuer_time = failuer_time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

package com.cicada.dao;

import java.util.Date;

import com.cicada.entity.Email;

public interface EmailDao {
//保存邮件
	void saveEmail(Email email);

	Date getEmail(Date send_time);

}

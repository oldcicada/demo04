package com.cicada.dao;

import java.util.Date;

import com.cicada.entity.Email;

public interface EmailDao {
//保存邮件
	void saveEmail(Email email);

	Date getEmail(Date send_time);
//根据id获得邮件信息
	Email getEmailMessage(int id);
	//根据时间获得邮件id
	int getEmailId(Date send_time);

	Email getEmailByNumber(String state);

}

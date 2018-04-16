package com.cicada.service;

import com.cicada.entity.Email;

public interface EmailService {
	// 保存邮件
	void saveEmail(Email email);

	// 根据时间获得邮件
	Long getEmail(Long send_time);

	// 根据时间获得邮件id
	int getEmailId(long send_time);

	// 根据email获得邮件信息
	public Email getEmailMessage(int id);
//根据流水号查询Email信息
	Email getEmailByNumber(String number);
}

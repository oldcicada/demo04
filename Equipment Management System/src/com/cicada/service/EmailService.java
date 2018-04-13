package com.cicada.service;

import com.cicada.entity.Email;

public interface EmailService {
//保存邮件
	void saveEmail(Email email);
	//根据时间获得邮件
	Long getEmail(Long send_time);
}

package com.cicada.serviceImpl;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.EmailDao;
import com.cicada.entity.Email;
import com.cicada.service.EmailService;
import com.cicada.util.SqlSessionFactoryUtil;

public class EmailServiceImpl implements EmailService {
	private SqlSession sqlSession = null;
	private EmailDao ed =null;
	//保存邮件
		public void saveEmail(Email email) {
			 sqlSession = SqlSessionFactoryUtil.getSqlSession();
			ed = sqlSession.getMapper(EmailDao.class);
			ed.saveEmail(email);
			sqlSession.commit();
			sqlSession.close();
		}
		//根据时间获得邮件
	 public Long getEmail(Long send_time) {
		 sqlSession = SqlSessionFactoryUtil.getSqlSession();
			ed = sqlSession.getMapper(EmailDao.class);
			Date date = new Date(send_time);
			Date failDate = ed.getEmail(date);
			long time = failDate.getTime();
			sqlSession.close();
			return time;
	 }
	//根据时间获得邮件id
	 public int getEmailId(long send_time) {
		 sqlSession = SqlSessionFactoryUtil.getSqlSession();
			ed = sqlSession.getMapper(EmailDao.class);
			Date date = new Date(send_time);
			int id = ed.getEmailId(date);
			sqlSession.close();
			return id;
	 }
	//根据email获得邮件信息
		public Email getEmailMessage(int id) {
			 sqlSession = SqlSessionFactoryUtil.getSqlSession();
				ed = sqlSession.getMapper(EmailDao.class);
				Email email = ed.getEmailMessage(id);
				sqlSession.close();
				return email;
		}
		//根据流水号查询Email信息
		public Email getEmailByNumber(String number) {
			 sqlSession = SqlSessionFactoryUtil.getSqlSession();
			 ed = sqlSession.getMapper(EmailDao.class);
			 Email email=ed.getEmailByNumber(number);
			 sqlSession.close();
				return email;
		}
}

package com.cicada.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.common.EmailUtil;
import com.cicada.entity.Email;
import com.cicada.entity.User;
import com.cicada.service.EmailService;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.EmailServiceImpl;
import com.cicada.serviceImpl.UserServiceImpl;

@WebServlet("/sendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiveMail=request.getParameter("email");
		UserService us=new UserServiceImpl();
		User user= us.getUserByEmail(receiveMail);
		if(user==null) {
			request.setAttribute("sendError", "出错了，可能是邮箱输入错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		Long code=System.currentTimeMillis();
		String content=null;
		try {
			Object messageContent = EmailUtil.resetPassword(user, code);
			content=(String) messageContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Long转换成日期
		Date send_time=new Date(code);
		//默认两分钟
		Date failuer_time=new Date(code+2*60*1000);
		Email email=new Email(content,receiveMail, send_time, failuer_time);
		EmailService es=new EmailServiceImpl();
		es.saveEmail(email);
		response.sendRedirect("https://mail.qq.com/");
	}

}

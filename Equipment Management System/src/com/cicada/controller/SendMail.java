package com.cicada.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.common.EmailUtil;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.UserServiceImpl;
import com.cicada.util.DateUtils;

@WebServlet("/sendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		UserService us=new UserServiceImpl();
		int userId= us.getUserIdByEmail(email);
		if(userId==-1) {
			request.setAttribute("sendError", "出错了，可能是邮箱输入错误！");
			return;
		}
		//EmailUtil.createMimeMessage(session, sendMail, sysUser, code);
	}

}

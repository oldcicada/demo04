package com.cicada.controller.mime;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.common.EmailUtil2;
import com.cicada.entity.Email;
import com.cicada.entity.User;
import com.cicada.service.EmailService;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.EmailServiceImpl;
import com.cicada.serviceImpl.UserServiceImpl;

@WebServlet("/view/mime/modifypass")
public class ModifypassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("emailMessage", "邮件发送成功后，登录邮箱点击链接修改密码");
		request.getRequestDispatcher("/WEB-INF/view/mime/modifypass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =request.getParameter("email").trim();
		UserService us=new UserServiceImpl();
		User user= us.getUserByEmail(email);
		if(user==null) {
			request.setAttribute("emailMessage", "出错了，可能是邮箱输入错误！");
			request.getRequestDispatcher("/WEB-INF/view/mime/modifypass.jsp").forward(request, response);
			return;
		}
		Long code=System.currentTimeMillis();
		String content=null;
		try {
			Object messageContent = EmailUtil2.resetPassword(user, code);
			content=(String) messageContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Long转换成日期
		Date send_time=new Date(code);
		//默认两分钟
		Date failuer_time=new Date(code+2*60*1000);
		Email ema=new Email(content,email, send_time, failuer_time);
		EmailService es=new EmailServiceImpl();
		es.saveEmail(ema);
		int id=es.getEmailId(send_time.getTime());
		request.setAttribute("id",id);
		request.setAttribute("email", email);
		request.getRequestDispatcher("/WEB-INF/view/mime/modifypassView.jsp").forward(request, response);
	}
}

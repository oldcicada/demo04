package com.cicada.controller.mime;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.common.EmailUtil2;
import com.cicada.entity.Email;
import com.cicada.entity.User;
import com.cicada.service.EmailService;
import com.cicada.serviceImpl.EmailServiceImpl;

@WebServlet("/view/mime/modifypass")
public class ModifypassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("emailMessage", "邮件发送成功后，登录邮箱点击链接修改密码");
		request.getRequestDispatcher("/WEB-INF/view/mime/modifypass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改自己的密码
		String email =request.getParameter("email").trim();
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(!email.equals(user.getEmail())) {
			request.setAttribute("emailMessage", "出错了，可能是邮箱输入错误！");
			request.getRequestDispatcher("/WEB-INF/view/mime/modifypass.jsp").forward(request, response);
			return;
		}
		String content=null;
		try {
			Object messageContent = EmailUtil2.resetPassword(user);
			content=(String) messageContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String login_name=user.getLogin_name();
		String state=""+System.currentTimeMillis();
		Email ema=new Email(content,email, login_name,state);
		EmailService es=new EmailServiceImpl();
		es.saveEmail(ema);
		request.setAttribute("state", state);
		request.getRequestDispatcher("/WEB-INF/view/mime/modifypassView.jsp").forward(request, response);
	}
}

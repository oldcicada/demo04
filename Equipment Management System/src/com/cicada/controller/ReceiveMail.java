package com.cicada.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.service.EmailService;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.EmailServiceImpl;
import com.cicada.serviceImpl.UserServiceImpl;

@WebServlet("/receiveMail")
public class ReceiveMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code").trim();
		String receiveMail = request.getParameter("receiveMail").trim();
		request.setAttribute("code", code);
		request.setAttribute("receiveMail", receiveMail);
		request.getRequestDispatcher("/receiveMail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long code = Long.parseLong(request.getParameter("code").trim());
		String receiveMail = request.getParameter("receiveMail").trim();
		String newPassword = request.getParameter("newPassword").trim();
		String confirmPassword = request.getParameter("confirmPassword").trim();
		EmailService es = new EmailServiceImpl();
		Long failTime = es.getEmail(code);
		if (failTime == null) {
			return;
		}
		if (System.currentTimeMillis() > failTime) {
			request.setAttribute("emailError", "邮件已失效！");
			request.setAttribute("code", code);
			request.setAttribute("receiveMail", receiveMail);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} else {
			if(!newPassword.equals(confirmPassword)) {
				request.setAttribute("passwordError", "两次密码不一致！");
				request.setAttribute("code", code);
				request.setAttribute("receiveMail", receiveMail);
				request.getRequestDispatcher("receiveMail.jsp").forward(request, response);
				return;
			}
			UserService us=new UserServiceImpl();
			//修改密码
			us.updatePassword(receiveMail,newPassword);
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}
}

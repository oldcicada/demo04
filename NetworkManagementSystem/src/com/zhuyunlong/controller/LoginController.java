package com.zhuyunlong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhuyunlong.dao.UserDao;
import com.zhuyunlong.pojo.User;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if("username".equals(cookie.getName())) {
					request.setAttribute("username", cookie.getValue());
				}
			}
		}
	
		request.getRequestDispatcher("view/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number =request.getParameter("number").trim();
		String password =request.getParameter("password").trim();
		String[] remerber =request.getParameterValues("remerber");
		UserDao ud=new UserDao();
		User user = ud.getUser(number, password);
		if(user==null) {
			request.setAttribute("error", "账号或密码不正确。");
			request.getRequestDispatcher("view/login.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			if(remerber==null) {
				response.sendRedirect(request.getContextPath() + "/index");
				return;
			}
			if("true".equals(remerber[0])) {
				Cookie cookies=new Cookie("username", number);
				cookies.setMaxAge(60*60*24*7);
				response.addCookie(cookies);
			}
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}
}

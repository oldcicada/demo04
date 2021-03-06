package com.cicada.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.entity.User;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.UserServiceImpl;
import com.cicada.util.Md5;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 记住密码
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("username".equals(cookie.getName())) {
					request.setAttribute("username", cookie.getValue());
					break;
				}
			}
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取login.jsp表单提交的信息
		String username = request.getParameter("number").trim();
		String password = request.getParameter("password").trim();
		String[] remerber = request.getParameterValues("remerber");
		// String pictureCode = request.getParameter("pictureCode");

		/*
		 * //判断验证码是否正确 if(!ValidateCodeUtil.validate(request, pictureCode)) {
		 * request.setAttribute("error", "请输入正确的验证码。");
		 * request.getRequestDispatcher("/login.jsp").forward(request, response);
		 * return; }
		 */

		// mybatis查询数据库获得user信息
		UserService us = new UserServiceImpl();
		// 将密码123456进行加密
		password = Md5.MD5(password);
		User user = us.login(username, password);
		if (user == null) {
			request.setAttribute("error", "账号或密码不正确。");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		// 登陆成功修改最后登录时间和IP;
		user.setLogin_ip(request.getServerName());
		user.setLogin_time(new Date());
		us.updateLoginMessage(user.getLogin_ip(), user.getId());

		// session存储user信息
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		if (remerber == null) {
			response.sendRedirect(request.getContextPath() + "/view/index");
			return;
		}
		// 点击 记住密码，Cookie存储username
		if ("true".equals(remerber[0])) {
			Cookie cookies = new Cookie("username", username);
			cookies.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookies);
		}
		// 登录成功跳转index
		response.sendRedirect(request.getContextPath() + "/view/index");
	}
}

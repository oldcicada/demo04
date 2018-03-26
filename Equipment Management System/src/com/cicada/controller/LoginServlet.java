package com.cicada.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String username = request.getParameter("number").trim();
		String password = request.getParameter("password").trim();
		String[] remerber = request.getParameterValues("remerber");
		UserDao ud = new com.cicada.dao.UserDao();
		int userid = ud.login(username, password);
		if (userid == -1) {
			request.setAttribute("error", "账号或密码不正确。");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("userid", userid);
		if (remerber == null) {
			response.sendRedirect(request.getContextPath() + "/view/index");
			return;
		}
		if ("true".equals(remerber[0])) {
			Cookie cookies = new Cookie("username", username);
			cookies.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookies);
		}
		response.sendRedirect(request.getContextPath() + "/view/index");
	}
}
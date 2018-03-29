package com.cicada.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.UserDao;
import com.cicada.entity.User;
import com.cicada.util.SqlSessionFactoryUtil;

@WebServlet("/view/mime/userinfo")
public class UserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		User user = ud.getUserMessage(userid);
		if (user == null) {
			return;
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/view/mime/userinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 修改个人信息
	}
}

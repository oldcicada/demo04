package com.cicada.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cicada.dao.EmployeeDao;
import com.cicada.entity.Employee;
import com.cicada.entity.User;
import com.cicada.util.SqlSessionFactoryUtil;

@WebServlet("/view/mime/userinfo")
public class UserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		EmployeeDao ed = sqlSession.getMapper(EmployeeDao.class);
		Employee employee = ed.getEmployeeById(user.getEquipmentId());
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/view/mime/userinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 修改个人信息
	}
}

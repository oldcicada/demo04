package com.cicada.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.dao.UserDao;
import com.cicada.entity.User;

@WebServlet("/view/sys/employeeList")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud=new UserDao();
		List<User> employees = ud.getAllUserMessage();
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("/WEB-INF/view/sys/employeeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String nickname = request.getParameter("nickname").trim();
		UserDao ud=new UserDao();
		if(username==""&&nickname=="") {
			request.setAttribute("error", "请输入登录名或者姓名！");
		}else {
			List<User> employees = ud.queryAllUserMessage(username, nickname);
			if(employees.isEmpty()) {
				request.setAttribute("error", "查无此人！");
			}
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("/WEB-INF/view/sys/employeeList.jsp").forward(request, response);
		}
	}
}

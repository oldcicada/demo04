package com.cicada.controller.sys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.service.UserService;
import com.cicada.serviceImpl.UserServiceImpl;

@WebServlet("/view/sys/resetPass")
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("userId").trim());
		UserService us=new UserServiceImpl();
		us.resetPass(id);
		response.sendRedirect(request.getContextPath()+"/view/sys/employeeList");
	}
}

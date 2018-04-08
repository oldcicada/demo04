package com.cicada.controller.sys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.cicada.common.PageDto;
import com.cicada.entity.User;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.UserServiceImpl;

@WebServlet("/view/sys/employeeList")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/sys/employeeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex").trim());
		int pageSize=Integer.parseInt(request.getParameter("pageSize").trim());
		String login_name =request.getParameter("login_name").trim();
		String name =request.getParameter("name").trim();
		//System.out.println("login_name:"+login_name+"--"+"name"+name+"--pageIndex:"+pageIndex+"--pageSize:"+pageSize);
		
		//查询出数据发送给前端页面处理
		UserService us=new UserServiceImpl();
		PageDto<User> pageDto=us.queryUserPage(pageIndex, pageSize, login_name, name);
		response.getWriter().print(JSON.toJSON(pageDto));
	}
}

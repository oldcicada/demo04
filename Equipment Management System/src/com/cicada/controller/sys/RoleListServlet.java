package com.cicada.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.entity.Role;
import com.cicada.service.RoleService;
import com.cicada.serviceImpl.RoleServiceImpl;

@WebServlet("/view/sys/roleList")
public class RoleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService rs=new RoleServiceImpl();
		List<Role> roleList = rs.getRoleList();
		System.out.println(roleList.get(0).getName());
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/WEB-INF/view/sys/roleList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

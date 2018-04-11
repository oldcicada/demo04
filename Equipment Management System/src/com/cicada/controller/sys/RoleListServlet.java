package com.cicada.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.cicada.entity.Role;
import com.cicada.service.RoleService;
import com.cicada.serviceImpl.RoleServiceImpl;

@WebServlet("/view/sys/roleList")
public class RoleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/sys/roleList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pageIndex=Integer.parseInt(request.getParameter("pageIndex").trim());
	int pageSize=Integer.parseInt(request.getParameter("pageSize").trim());
	String name=request.getParameter("name").trim();
	RoleService rs=new RoleServiceImpl();
	List<Role> roleList = rs.getPageRoleList(name,pageIndex,pageSize);
	response.getWriter().print(JSON.toJSON(roleList));
	}

}

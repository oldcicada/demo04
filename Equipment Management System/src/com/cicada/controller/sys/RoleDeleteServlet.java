package com.cicada.controller.sys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.cicada.common.MenuTreeDto;
import com.cicada.service.RoleMenuService;
import com.cicada.service.RoleService;
import com.cicada.service.UserRoleService;
import com.cicada.serviceImpl.RoleMenuServiceImpl;
import com.cicada.serviceImpl.RoleServiceImpl;
import com.cicada.serviceImpl.UserRoleServiceImpl;

@WebServlet("/view/sys/roleDelete")
public class RoleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、根据id删除role表中记录
		int id = Integer.parseInt(request.getParameter("id").trim());
		RoleService rs = new RoleServiceImpl();
		rs.deleteByRoleId(id);
		// 2、根据id删除user_role中记录
		UserRoleService urs = new UserRoleServiceImpl();
		urs.deleteByRoleId(id);
		// 3、根据id删除role_menu中记录
		RoleMenuService rms = new RoleMenuServiceImpl();
		rms.deleteByRoleId(id);
		response.sendRedirect(request.getContextPath() + "/view/sys/roleList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		RoleMenuService rms = new RoleMenuServiceImpl();
		List<MenuTreeDto> tree = new ArrayList<>();
		if (id != "" || id == null) {
			int roleId = Integer.parseInt(id);
			tree = rms.getMenuTree(roleId);
		} else {
			tree = rms.getAllMenuTree();
		}
		response.getWriter().print(JSON.toJSON(tree));
	}
}

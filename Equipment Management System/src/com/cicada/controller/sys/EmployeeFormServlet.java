package com.cicada.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.common.DictionaryUtil;
import com.cicada.entity.Dictionary;
import com.cicada.entity.User;
import com.cicada.service.RoleService;
import com.cicada.service.UserRoleService;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.RoleServiceImpl;
import com.cicada.serviceImpl.UserRoleServiceImpl;
import com.cicada.serviceImpl.UserServiceImpl;
import com.cicada.util.Md5;

@WebServlet("/view/sys/employeeForm")
public class EmployeeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取性别字典项
		List<Dictionary> dictionary = DictionaryUtil.queryDictionaryByType("sex");
		request.setAttribute("sexes", dictionary);
		// 2、获取所有角色
		RoleService rs = new RoleServiceImpl();
		request.setAttribute("roleList", rs.getRoleList());
		request.getRequestDispatcher("/WEB-INF/view/sys/employeeForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login_name = request.getParameter("login_name").trim();
		String name = request.getParameter("name").trim();
		String number = request.getParameter("number").trim();
		String password = Md5.MD5(request.getParameter("number").trim());
		String phone = request.getParameter("phone").trim();
		String sex = request.getParameter("sex").trim();
		String email = request.getParameter("email").trim();
		String description = request.getParameter("description").trim();
		int roleId = Integer.parseInt(request.getParameter("roleId").trim());
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("user");
		// 获取不到登录的用户，直接返回。
		if (loginUser == null) {
			return;
		}
		String updater=loginUser.getLogin_name();
		String founder=loginUser.getLogin_name();
		User user=new User(login_name, name, password, number, sex, email, phone, founder, updater, description);
		UserService us = new UserServiceImpl();
		//1、user表添加用户
		us.addUserMessage(user);
		//2、user_role表添加记录
		int userId = us.getUserId(login_name, password);
		UserRoleService urs=new UserRoleServiceImpl();
		urs.add(userId,roleId);
		response.sendRedirect(request.getContextPath() + "/view/sys/employeeList");
	}
}

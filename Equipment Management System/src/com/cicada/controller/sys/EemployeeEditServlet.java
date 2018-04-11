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

@WebServlet("/view/sys/employeeEdit")
public class EemployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("id"));
	UserService us=new UserServiceImpl();
	User user=us.getUserById(id);
	request.setAttribute("user", user);
	// 1、获取性别字典项
	List<Dictionary> dictionary = DictionaryUtil.queryDictionaryByType("sex");
	request.setAttribute("sexes", dictionary);
	//2、获取所有角色
	RoleService rs = new RoleServiceImpl();
	request.setAttribute("roleList", rs.getRoleList());
	// 3、获取用户角色id
	UserRoleService urs=new UserRoleServiceImpl();
	int role_id=urs.getRoleIdByUserId(id);
	request.setAttribute("role_id",role_id);
	request.getRequestDispatcher("/WEB-INF/view/sys/employeeEdit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").trim());	
		String login_name = request.getParameter("login_name").trim();	
		String name = request.getParameter("name").trim();	
		String phone = request.getParameter("phone").trim();
		String sex = request.getParameter("sex").trim();
		String email = request.getParameter("email").trim();
		HttpSession session = request.getSession();
		User loginUser =(User)session.getAttribute("user");
		
		//获取不到登录的用户，直接返回。
		if(loginUser==null) {
			return;
		}
		User user=new User(id, login_name, name, sex, email, phone, loginUser.getLogin_name());
		UserService us=new UserServiceImpl();
		us.UpdateUserMessage(user);
		response.sendRedirect(request.getContextPath()+"/view/sys/employeeList");
	}
}

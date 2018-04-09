package com.cicada.controller.sys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.entity.User;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.UserServiceImpl;

@WebServlet("/view/sys/employeeEdit")
public class EemployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("id"));
	UserService us=new UserServiceImpl();
	User user=us.getUserById(id);
	/*if(user==null) {
		request.setAttribute("editResult", "查无此人！");
		request.getRequestDispatcher("/WEB-INF/view/sys/employeeList.jsp").forward(request, response);
		return;
	}*/
	request.setAttribute("user", user);
	request.getRequestDispatcher("/WEB-INF/view/sys/employeeEdit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").trim());	
		String login_name = request.getParameter("login_name").trim();	
		String name = request.getParameter("name").trim();	
		String phone = request.getParameter("phone").trim();	
		String email = request.getParameter("email").trim();
		HttpSession session = request.getSession();
		User loginUser =(User)session.getAttribute("user");
		
		//获取不到登录的用户，直接返回。
		if(loginUser==null) {
			return;
		}
		String updater=loginUser.getLogin_name();
		System.out.println(id);
		UserService us=new UserServiceImpl();
		Map<Object,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("login_name", login_name);
		map.put("name", name);
		map.put("phone", phone);
		map.put("eamil", email);
		map.put("updater", updater);
		us.UpdateUserMessage(map);
		response.sendRedirect(request.getContextPath()+"/view/sys/employeeList");
	}
}

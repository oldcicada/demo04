package com.zhuyunlong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuyunlong.dao.UserDao;
import com.zhuyunlong.dao.UserinfoDao;
import com.zhuyunlong.pojo.User;
@WebServlet("/adduser")
public class AdduserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/adduser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name").trim();
		String number = request.getParameter("number").trim();
		String password = request.getParameter("password").trim();
		String email = request.getParameter("email").trim();
		int sex = Integer.parseInt(request.getParameter("sex").trim());
		int roomnumber = Integer.parseInt(request.getParameter("roomnumber").trim());
		User user=new User();
		user.setName(name);
		user.setNumber(number);
		user.setPassword(password);
		UserDao ud=new UserDao();
		ud.add(user);
		UserinfoDao uid=new UserinfoDao();
		System.out.println(user.getId());
		uid.add(number, email, sex, roomnumber);
		response.sendRedirect(request.getContextPath()+"/userlist");
	}

}

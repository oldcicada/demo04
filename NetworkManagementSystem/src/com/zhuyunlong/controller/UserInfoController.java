package com.zhuyunlong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhuyunlong.dao.UserinfoDao;
import com.zhuyunlong.pojo.User;
import com.zhuyunlong.pojo.Userinfo;

@WebServlet("/userinfo")
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user =(User) session.getAttribute("user");
		request.setAttribute("number",user.getName());
		UserinfoDao ud=new UserinfoDao();
		Userinfo userinfo = ud.getUser(user.getNumber());
		request.setAttribute("email", userinfo.getEmail());
		String sex=userinfo.getSex()==1?"男":"女";
		request.setAttribute("sex",sex);
		request.getRequestDispatcher("view/mine/userinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

package com.zhuyunlong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuyunlong.dao.UserinfoDao;

@WebServlet("/userlist")
public class UserlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserinfoDao rd=new UserinfoDao();
		List<Object[]> userlist = rd.getRoomList();
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("view/userlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

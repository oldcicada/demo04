package com.zhuyunlong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuyunlong.dao.RoomDao;
@WebServlet("/addroom")
public class AddroomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/addroom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int roomnumber = Integer.parseInt(request.getParameter("roomnumber").trim());
		int roomnum = Integer.parseInt(request.getParameter("roomnum").trim());
		RoomDao rd=new RoomDao();
		rd.add(roomnumber, roomnum);
		request.setAttribute("success", "新寝室添加成功！");
		request.getRequestDispatcher("view/roomlist.jsp").forward(request, response);
	}

}

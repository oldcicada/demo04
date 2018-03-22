package com.zhuyunlong.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuyunlong.dao.RoomDao;

@WebServlet("/setroomstate")
public class Setroomstatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/setroomstate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int roomnumber = Integer.parseInt(request.getParameter("roomnumber").trim());
		int state = Integer.parseInt(request.getParameter("state").trim());
		RoomDao rd=new RoomDao();
		rd.updateRoomstate(roomnumber, state);
		response.sendRedirect(request.getContextPath()+"/roomlist");
	}
}

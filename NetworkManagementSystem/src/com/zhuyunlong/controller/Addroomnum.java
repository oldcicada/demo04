package com.zhuyunlong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuyunlong.dao.RoomDao;
import com.zhuyunlong.pojo.Room;

@WebServlet("/addroomnum")
public class Addroomnum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomDao rd=new RoomDao();
		List<Room> roomlist = rd.getRoomList();
		request.setAttribute("roomlist", roomlist);
		request.getRequestDispatcher("view/addroomnum.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

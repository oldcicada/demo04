package com.cicada.controller.sys;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.service.RoomService;
import com.cicada.serviceImpl.RoomServiceImpl;

@WebServlet("/view/sys/roomDelete")
public class RoomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		int roomId=Integer.parseInt(request.getParameter("id"));
		RoomService rs=new RoomServiceImpl();
		rs.deleteById(roomId);
		response.sendRedirect(request.getContextPath()+"/view/sys/roomList");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

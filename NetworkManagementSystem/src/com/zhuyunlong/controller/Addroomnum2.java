package com.zhuyunlong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuyunlong.dao.RoomDao;

@WebServlet("/addroomnum2")
public class Addroomnum2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id").trim());
		RoomDao rd=new RoomDao();
		int roomnum = rd.getRoomnum(id);
		if(roomnum>1) {
			roomnum--;
		}else {
			roomnum=0;
		}
		rd.updateRoomnum(roomnum, id);
		response.sendRedirect(request.getContextPath()+"/addroomnum");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

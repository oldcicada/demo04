package com.cicada.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.common.DictionaryUtil;
import com.cicada.entity.Dictionary;
import com.cicada.entity.Room;
import com.cicada.service.RoomService;
import com.cicada.serviceImpl.RoomServiceImpl;

@WebServlet("/view/sys/roomEdit")
public class RoomEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dictionary> roomStates = DictionaryUtil.queryDictionaryByType("roomstate");
		request.setAttribute("roomStates", roomStates);
		List<Dictionary> roomTypes = DictionaryUtil.queryDictionaryByType("roomtype");
		request.setAttribute("roomTypes", roomTypes);
		int id=Integer.parseInt(request.getParameter("id").trim());
		RoomService rs=new RoomServiceImpl();
		Room room = rs.getRoomMessageById(id);
		request.setAttribute("room", room);
		request.getRequestDispatcher("/WEB-INF/view/sys/roomEdit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id").trim());
		String address=request.getParameter("address").trim();
		String number=request.getParameter("number").trim();
		String state=request.getParameter("state").trim();
		String linker=request.getParameter("linker").trim();
		String type=request.getParameter("type").trim();
		String phone=request.getParameter("phone").trim();
		Room room=new Room(id,address, number, type, linker, phone, state);
		RoomService rs=new RoomServiceImpl();
		rs.updateById(room);
		response.sendRedirect(request.getContextPath()+"/view/sys/roomList");
	}

}

package com.cicada.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.cicada.common.DictionaryUtil;
import com.cicada.common.PageDto;
import com.cicada.entity.Dictionary;
import com.cicada.entity.Room;
import com.cicada.service.RoomService;
import com.cicada.serviceImpl.RoomServiceImpl;

@WebServlet("/view/sys/roomList")
public class RoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dictionary> roomTypes= DictionaryUtil.queryDictionaryByType("roomtype");
		request.setAttribute("roomTypes", roomTypes);
		request.getRequestDispatcher("/WEB-INF/view/sys/roomList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex").trim());
		int pageSize=Integer.parseInt(request.getParameter("pageSize").trim());
		String address =request.getParameter("address").trim();
		String number =request.getParameter("number").trim();
		String type =request.getParameter("type").trim();
		//查询出数据发送给前端页面处理
		RoomService rs=new RoomServiceImpl();
		PageDto<Room> pageDto=rs.queryRoomPage(pageIndex, pageSize, address, number,type);
		response.getWriter().print(JSON.toJSON(pageDto));
	}

}

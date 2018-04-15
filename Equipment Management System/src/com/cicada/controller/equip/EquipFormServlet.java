package com.cicada.controller.equip;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.common.DictionaryUtil;
import com.cicada.entity.Dictionary;
import com.cicada.entity.Equipment;
import com.cicada.entity.Room;
import com.cicada.service.EquipmentService;
import com.cicada.service.RoomService;
import com.cicada.serviceImpl.EquipmentServiceImpl;
import com.cicada.serviceImpl.RoomServiceImpl;

@WebServlet("/view/equip/equipForm")
public class EquipFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dictionary> equipmentTypes = DictionaryUtil.queryDictionaryByType("equiptype");
		request.setAttribute("equipmentTypes",equipmentTypes );
		List<Dictionary> equipmentStates = DictionaryUtil.queryDictionaryByType("equipstate");
		request.setAttribute("equipmentStates",equipmentStates);
		RoomService rs=new RoomServiceImpl();
		List<Room> roomList=rs.getRoom();
		request.setAttribute("roomList", roomList);
		request.getRequestDispatcher("/WEB-INF/view/equip/equipForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name").trim();
		String code=request.getParameter("code").trim();
		String type=request.getParameter("type").trim();
		String remark=request.getParameter("remark").trim();
		String state=request.getParameter("state").trim();
		int room_id=Integer.parseInt(request.getParameter("room_id").trim());
		Equipment equip=new Equipment(name, code, type, remark, state, room_id);
		EquipmentService es=new EquipmentServiceImpl();
		es.addEquipment(equip);
		response.sendRedirect(request.getContextPath()+"/view/equip/equipList");
	}
}

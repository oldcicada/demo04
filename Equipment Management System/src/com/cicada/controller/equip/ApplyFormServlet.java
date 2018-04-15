package com.cicada.controller.equip;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.entity.Repair;
import com.cicada.entity.User;
import com.cicada.service.EquipmentService;
import com.cicada.service.RepairService;
import com.cicada.serviceImpl.EquipmentServiceImpl;
import com.cicada.serviceImpl.RepairServiceImpl;
import com.cicada.util.DateUtils;

@WebServlet("/view/equip/applyForm")
public class ApplyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		String equipmentId = request.getParameter("id");
		request.setAttribute("equipmentId", equipmentId);
		request.getRequestDispatcher("/WEB-INF/view/equip/applyForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int equipmentId=Integer.parseInt(request.getParameter("id").trim());
	String title=request.getParameter("title");
	String description=request.getParameter("description");
	HttpSession session = request.getSession();
	User user=(User)session.getAttribute("user");
	int send_user_id=user.getId();
	EquipmentService es=new EquipmentServiceImpl();
	int room_id=es.getRoomId(equipmentId);
	String pattern="yyyyMMddHHmmss";
	String number=DateUtils.formatDate(new Date(), pattern);
	RepairService rs=new RepairServiceImpl();
	Repair repair=new Repair(number, title, description, room_id, equipmentId, send_user_id);
	rs.addRepair(repair);
	response.sendRedirect(request.getContextPath()+"/view/equip/applyList");
	}

}

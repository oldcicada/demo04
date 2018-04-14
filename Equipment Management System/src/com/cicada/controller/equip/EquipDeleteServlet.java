package com.cicada.controller.equip;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.service.EquipmentService;
import com.cicada.serviceImpl.EquipmentServiceImpl;

@WebServlet("/view/equip/equipDelete")
public class EquipDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/equip/equipForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int equipmentId=Integer.parseInt(request.getParameter("id").trim());
		EquipmentService es=new EquipmentServiceImpl();
		es.deleteById(equipmentId);
		response.sendRedirect(request.getContextPath()+"/view/equip/equipList");
	}
}

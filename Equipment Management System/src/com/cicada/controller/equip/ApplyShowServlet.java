package com.cicada.controller.equip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.cicada.entity.Repair;
import com.cicada.service.RepairService;
import com.cicada.serviceImpl.RepairServiceImpl;

@WebServlet("/view/equip/applyShow")
public class ApplyShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int repairId=Integer.parseInt(request.getParameter("id").trim());
		request.setAttribute("repairId", repairId);
		request.getRequestDispatcher("/WEB-INF/view/equip/applyShow.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id").trim());
		RepairService rs=new RepairServiceImpl();
		Repair repair= rs.getRepairMessage(id);
		response.getWriter().print(JSON.toJSON(repair));
	}
}

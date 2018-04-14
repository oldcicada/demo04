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
import com.cicada.service.RepairService;
import com.cicada.serviceImpl.RepairServiceImpl;

@WebServlet("/view/equip/applyEdit")
public class ApplyEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int repairId =Integer.parseInt(request.getParameter("id").trim());
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int get_user_id=user.getId();
		Date done_time=new Date();
		String result="处理成功";
		int money=200;
		Repair repair=new Repair(repairId, get_user_id, done_time, result, money);
		
		RepairService rs=new  RepairServiceImpl();
		rs.updateState(repair);
		response.sendRedirect(request.getContextPath()+"/view/eqiup/applyList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

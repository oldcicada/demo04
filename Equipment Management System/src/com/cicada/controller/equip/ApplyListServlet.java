package com.cicada.controller.equip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.cicada.common.PageDto;
import com.cicada.entity.Repair;
import com.cicada.service.RepairService;
import com.cicada.serviceImpl.RepairServiceImpl;

@WebServlet("/view/eqiup/applyList")
public class ApplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/equip/applyList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex").trim());
		int pageSize=Integer.parseInt(request.getParameter("pageSize").trim());
		String name=request.getParameter("name").trim();
		String state=request.getParameter("state").trim();
		String type=request.getParameter("type").trim();
		RepairService rs=new RepairServiceImpl();
		PageDto<Repair> dto = rs.getRepairPage(pageIndex,pageSize,name,type,state);
		response.getWriter().print(JSON.toJSON(dto));
	}
}

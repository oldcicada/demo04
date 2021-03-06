package com.cicada.controller.equip;

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
import com.cicada.entity.Equipment;
import com.cicada.service.EquipmentService;
import com.cicada.serviceImpl.EquipmentServiceImpl;

@WebServlet("/view/equip/equipList")
public class EquipListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dictionary> equipTypes = DictionaryUtil.queryDictionaryByType("equiptype");
		request.setAttribute("equipTypes", equipTypes);
		List<Dictionary> equipStates = DictionaryUtil.queryDictionaryByType("equipstate");
		request.setAttribute("equipStates", equipStates);
		request.getRequestDispatcher("/WEB-INF/view/equip/equipList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex").trim());
		int pageSize=Integer.parseInt(request.getParameter("pageSize").trim());
		String name=request.getParameter("name").trim();
		String state=request.getParameter("state").trim();
		String type=request.getParameter("type").trim();
		EquipmentService es=new EquipmentServiceImpl();
		PageDto<Equipment> dto = es.getEquipmentPage(pageIndex,pageSize,name,type,state);
		response.getWriter().print(JSON.toJSON(dto));
	}

}

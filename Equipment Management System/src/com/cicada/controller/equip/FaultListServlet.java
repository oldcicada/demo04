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

@WebServlet("/view/equip/faultList")
public class FaultListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dictionary> equipmentTypes = DictionaryUtil.queryDictionaryByType("equiptype");
		request.setAttribute("equipmentTypes", equipmentTypes);
		List<Dictionary> repairsTates = DictionaryUtil.queryDictionaryByType("repairstate");
		request.setAttribute("repairsTates", repairsTates);
		request.getRequestDispatcher("/WEB-INF/view/equip/faultList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

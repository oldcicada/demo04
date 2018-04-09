package com.cicada.controller.sys;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.entity.Dictionary;
import com.cicada.service.DictionaryService;
import com.cicada.serviceImpl.DictionaryServiceImpl;

@WebServlet("/view/sys/dictForm")
public class DictFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/sys/dictForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type").trim();
		String value=request.getParameter("value").trim();
		String tag=request.getParameter("tag").trim();
		String description=request.getParameter("description").trim();
		int sort=Integer.parseInt(request.getParameter("sort").trim());
		Dictionary dic=new Dictionary();
		dic.setDescription(description);
		dic.setSort(sort);
		dic.setTag(tag);
		dic.setValue(value);
		dic.setType(type);
		DictionaryService ds=new DictionaryServiceImpl();
		ds.addDictionary(dic);
		response.sendRedirect(request.getContextPath()+"/view/sys/dictList");
	}
}

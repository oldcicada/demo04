package com.cicada.controller.sys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cicada.service.DictionaryService;
import com.cicada.serviceImpl.DictionaryServiceImpl;

@WebServlet("/view/sys/dictDelete")
public class DictDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DictionaryService ds=new DictionaryServiceImpl();
		ds.deleteDictionary(id);
		response.sendRedirect(request.getContextPath()+"/view/sys/dictList");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

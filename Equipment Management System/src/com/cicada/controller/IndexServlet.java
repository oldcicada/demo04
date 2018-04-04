package com.cicada.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.entity.Menu;
import com.cicada.entity.User;
import com.cicada.service.MenuService;
import com.cicada.serviceImpl.MenuServiceImpl;

@WebServlet("/view/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//动态生成列表
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		MenuService ms = new MenuServiceImpl();
		List<Menu> menuList = ms.getMenuList(user.getId());
		List<Menu> list = menuList.get(0).getMenus();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}

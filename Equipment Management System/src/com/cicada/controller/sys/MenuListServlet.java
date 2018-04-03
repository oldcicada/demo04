package com.cicada.controller.sys;

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

@WebServlet("/view/sys/menuList")
public class MenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		MenuService ms = new MenuServiceImpl();
		List<Menu> menuList = ms.getMenuList(user.getId());
		System.out.println(menuList.size());
		for (Menu menu : menuList) {
			System.out.print(menu.getMenus().get(0).toString()+"\t");
			System.out.println();
		}
		request.getRequestDispatcher("/WEB-INF/view/sys/menuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

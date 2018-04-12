package com.cicada.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.common.DictionaryUtil;
import com.cicada.entity.Dictionary;
import com.cicada.entity.Role;
import com.cicada.entity.User;
import com.cicada.service.RoleMenuService;
import com.cicada.service.RoleService;
import com.cicada.serviceImpl.RoleMenuServiceImpl;
import com.cicada.serviceImpl.RoleServiceImpl;

@WebServlet("/view/sys/roleForm")
public class RoleFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dictionary> show = DictionaryUtil.queryDictionaryByType("view");
		request.setAttribute("show", show);
		request.getRequestDispatcher("/WEB-INF/view/sys/roleForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code").trim();
		String description=request.getParameter("description").trim();
		String name=request.getParameter("name").trim();
		String used=request.getParameter("used").trim();
		String checkCodes=request.getParameter("checkCodes").trim();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String updater=user.getLogin_name();
		String founder=user.getLogin_name();
		//1、添加role表
		Role role=new Role(name, code, used,founder, updater, description);
		RoleService rs=new RoleServiceImpl();
		rs.addRoleMessage(role);
		int roleId = rs.getRoleIdByCode(code);
		//2、添加Role_menu表
		String[] menu_id=checkCodes.split(",|，");
		int menuId[]=new int[menu_id.length];
		try {
			for (int i=0;i<menu_id.length;i++) {
				menuId[i]=Integer.parseInt(menu_id[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println(e+"String转int错误。");
		}
		RoleMenuService rms=new RoleMenuServiceImpl();
		rms.add(roleId,menuId);
		response.sendRedirect(request.getContextPath()+"/view/sys/roleList");
	}

}

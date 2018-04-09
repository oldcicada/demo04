package com.cicada.controller.mime;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.common.DictionarytUtil;
import com.cicada.entity.Dictionary;
import com.cicada.entity.User;

@WebServlet("/view/mime/userinfo")
public class UserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		// 1、获取性别字典项
		List<Dictionary> dictionary = DictionarytUtil.queryDictionaryByType("sex");
		request.setAttribute("sexs", dictionary);
		/*// 2、获取所有角色
		SysRoleService sysRoleService = new SysRoleServiceImpl();
		request.setAttribute("roleList", sysRoleService.queryAllRole());*/
		// 3、获取用户角色id
		
		request.getRequestDispatcher("/WEB-INF/view/mime/userinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 修改个人信息
	}
}

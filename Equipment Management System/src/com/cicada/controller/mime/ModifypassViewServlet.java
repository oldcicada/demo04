package com.cicada.controller.mime;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cicada.entity.Email;
import com.cicada.service.EmailService;
import com.cicada.service.UserService;
import com.cicada.serviceImpl.EmailServiceImpl;
import com.cicada.serviceImpl.UserServiceImpl;

@WebServlet("/view/mime/modifypassView")
public class ModifypassViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/mime/modifypassView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email").trim();
		int id =Integer.parseInt(request.getParameter("id").trim());
		
		String newPassword = request.getParameter("newPassword").trim();
		String confirmPassword = request.getParameter("confirmPassword").trim();
		String printCode =request.getParameter("code").trim();
		
		EmailService es = new EmailServiceImpl();
		Email emailMessage= es.getEmailMessage(id);
		Long failTime=emailMessage.getFailuer_time().getTime();
		String content=emailMessage.getContent();
		String code=content.substring(content.length()-6,content.length());
		System.out.println(code);
		if (failTime==null ||System.currentTimeMillis() > failTime) {
			request.setAttribute("emailError", "邮件已失效！请点击<a href='view/mime/modifypass'>重新发送邮件</a>");
			request.getRequestDispatcher("/WEB-INF/view/mime/modifypassView.jsp").forward(request, response);
			return;
		} else {
			if(!newPassword.equals(confirmPassword)) {
				request.setAttribute("passwordError", "两次密码不一致！");
				request.setAttribute("id", id);
				request.setAttribute("email", email);
				request.getRequestDispatcher("/WEB-INF/view/mime/modifypassView.jsp").forward(request, response);
				return;
			}
			if(!printCode.equals(code)) {
				request.setAttribute("codeError", "验证码错误！");
				request.setAttribute("id", id);
				request.setAttribute("email", email);
				request.getRequestDispatcher("/WEB-INF/view/mime/modifypassView.jsp").forward(request, response);
				return;
			}
			UserService us=new UserServiceImpl();
			//修改密码
			us.updatePassword(email,newPassword);
			//密码修改成功，如何让用户知道？
			
			//跳转登录界面重新登陆
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}
}

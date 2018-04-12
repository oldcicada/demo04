package com.cicada.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.cicada.common.PageDto;
import com.cicada.entity.Dictionary;
import com.cicada.service.DictionaryService;
import com.cicada.serviceImpl.DictionaryServiceImpl;

@WebServlet("/view/sys/dictList")
public class DictListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DictionaryService ds=new DictionaryServiceImpl();
		List<Dictionary> dictionaryList=ds.queryAllDictionary();
		request.setAttribute("dictionaryList",dictionaryList );
		request.getRequestDispatcher("/WEB-INF/view/sys/dictList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex").trim());
		int pageSize=Integer.parseInt(request.getParameter("pageSize").trim());
		String type=request.getParameter("type").trim();
		String tag=request.getParameter("tag").trim();
		DictionaryService ds=new DictionaryServiceImpl();
		PageDto<Dictionary> dto = ds.queryDictionaries(pageIndex,pageSize,type,tag);
		response.getWriter().print(JSON.toJSON(dto));
	}

}

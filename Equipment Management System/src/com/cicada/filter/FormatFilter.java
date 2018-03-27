package com.cicada.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class FormatFilter implements Filter {

	public FormatFilter() {
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpReponse = (HttpServletResponse) response;
		// post方式设置编码为 utf-8
		httpRequest.setCharacterEncoding("utf-8");
		httpReponse.setContentType("text/html;charset=UTF-8");
		// get需要使用装饰者模式修改编码。
		/*
		 * l 继承：AA类继承a对象的类型：A类，
		 * 然后重写fun1()方法，其中重写的fun1()方法就是被增强的方法。但是，继承必须要知道a对象的真实类型，然后才能去继承。
		 * 如果我们不知道a对象的确切类型，而只知道a对象是IA接口的实现类对象，那么就无法使用继承来增强a对象了；
		 * 2装饰者模式：AA类去实现a对象相同的接口：IA接口， 还需要给AA类传递a对象，然后在AA类中所有的方法实现都是通过代理a对象的相同方法完成的，
		 * 只有fun1()方法在代理a对象相同方法的前后添加了一些内容，这就是对fun1()方法进行了增强；
		 */
		/*EncodingRequest er=new EncodingRequest(httpRequest);*/
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

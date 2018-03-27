package com.cicada.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/* 网站统计每个IP地址访问本网站的次数。
 * 统计工作需要在所有资源之前执行，放到IPCountFilter中,不做拦截操作！只用来做统计。
 * 用Map<String,Integer>存统计的数据。整个网站只需要一个Map即可！
 * 使用IP为key，访问次数为value
 * */
@WebFilter("/*")
public class IPCountFilter implements Filter {
	// web容器启动时创建的对象，代表当前web服务
	private ServletContext context;
	public IPCountFilter() {
	}

	public void destroy() {
	}

	@SuppressWarnings("unchecked") // 忽略警告
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String ip = req.getRemoteAddr();
		Map<String, Integer> map = (Map<String, Integer>) context.getAttribute("ipCountMap");
		Integer count = map.get(ip);
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		map.put(ip, count);
		context.setAttribute("ipCountMap",map);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//得到application
		context=fConfig.getServletContext();
		// 新建一个LinkedHashMap集合，它保存了记录的插入顺序。
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		// Collection.synchronizedMap();使集合线程安全
		Map<String, Integer> ipCountMap = Collections.synchronizedMap(linkedHashMap);
		// 将集合添加到application中
		context.setAttribute("ipCountMap", ipCountMap);
	}

}

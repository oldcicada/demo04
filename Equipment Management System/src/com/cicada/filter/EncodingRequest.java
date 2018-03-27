package com.cicada.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
//HttpServletRequestWrapper类是HttpServletRequest的装饰类，EncodingRequest继承它，重写其中需要增强的方法
public class EncodingRequest extends HttpServletRequestWrapper{

	public EncodingRequest(HttpServletRequest request) {
		super(request);
		
	}
    public String getParameter(String name) {

        HttpServletRequest request= (HttpServletRequest) getRequest();

        String method = request.getMethod();

        if(method.equalsIgnoreCase("post")) {

            try {
            	
               request.setCharacterEncoding("utf-8");

            } catch (UnsupportedEncodingException e) {}

        } else if(method.equalsIgnoreCase("get")) {

            String value = request.getParameter(name);

            try {

               value = new String(name.getBytes("ISO-8859-1"), "utf-8");

            } catch (UnsupportedEncodingException e) {

            }

            return value;

        }

        return request.getParameter(name);

     }
}

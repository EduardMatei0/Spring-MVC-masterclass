package com.eduardmatei.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service
public class HeaderInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("Greeting", "We hope you have a scarry Halloween!!");
		String location = request.getParameter("locationName");
		if(location != null) {
			request.setAttribute("locationName", location);
		}
		
		return true;
	}
	
	
}

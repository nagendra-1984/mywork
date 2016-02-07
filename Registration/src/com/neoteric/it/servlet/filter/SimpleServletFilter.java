package com.neoteric.it.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SimpleServletFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		// TODO Auto-generated method stub

	    String myParam = request.getParameter("myParam");

	    if(!"blockTheRequest".equals(myParam)){
	    	System.out.println("^%^ Filter Class received the request ^%^");
	        filterChain.doFilter(request, response);
	    }
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    httpResponse.getWriter().write("a different response... e.g in HTML");

		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
}

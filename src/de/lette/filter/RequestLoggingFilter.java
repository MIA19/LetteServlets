package de.lette.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Atm only for debug purposes
 * @author invalid
 */
@WebFilter(filterName = "RequestLoggingFilter", urlPatterns = {"/*"})
public class RequestLoggingFilter implements Filter {

	private ServletContext context;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		var req = (HttpServletRequest) request;
		var params = req.getParameterNames();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(req.getRemoteAddr() + "::Request Params::{"+name+"="+value+"}");
		}
		
		var cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
	}

}

package de.lette.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class AuthenticationFilter implements Filter {

	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		var req = (HttpServletRequest) request;
		var res = (HttpServletResponse) response;
		
		var uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		var session = req.getSession(false);
		if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
			this.context.log("Unauthorized access request");
			res.sendRedirect("login.html");
		}else{
			chain.doFilter(request, response);
		}
		
	}
	
	@Override
	public void destroy() {
	}
}
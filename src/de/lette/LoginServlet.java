package de.lette;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private final String userID = "admin";
	private final String password = "password";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var user = request.getParameter("user");
		var pwd = request.getParameter("pwd");
		if(userID.equals(user) && password.equals(pwd)){
			var session = request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(30*60);
			var userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("requestForm.xhtml");
		}else{
			var rd = getServletContext().getRequestDispatcher("/login.html");
			var out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

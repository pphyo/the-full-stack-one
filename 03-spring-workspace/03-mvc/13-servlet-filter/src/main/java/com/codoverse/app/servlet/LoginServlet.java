package com.codoverse.app.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if("admin".equals(username) && "Admin@123".equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", username);
			
			resp.sendRedirect("auth/dashboard.jsp");
		} else {
			resp.sendRedirect("index.jsp?error=1");
		}
	}

}

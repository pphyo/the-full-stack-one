package com.codoverse.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("""
				<!DOCTYPE html>
				<html>
					<head>
					<meta charset="UTF-8">
					<title>Very First Servlet</title>
					</head>
					<body>
						<h1>Hello from HelloController</h1>
						<a href="/">Back</a>
					</body>
				</html>
				""").flush();
	}
	

}

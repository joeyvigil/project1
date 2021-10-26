package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet {

	private static final long serialVersionUID = 7433966802277142976L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("current user3 "+req.getSession().getAttribute("currentuser"));
		req.getRequestDispatcher("/html/pastticket.html").forward(req, res);
		
	}
	
}

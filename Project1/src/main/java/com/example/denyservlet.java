package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class denyservlet extends HttpServlet {
	
	private static final long serialVersionUID = 5545378106757703961L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("in doPost of deny Servlet");
		req.getRequestDispatcher(denyDispatcher.process(req)).forward(req, res);
	}


}

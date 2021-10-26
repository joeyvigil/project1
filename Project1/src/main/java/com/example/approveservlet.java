package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class approveservlet extends HttpServlet{
	
	private static final long serialVersionUID = 1026997527541397321L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("in doPost of approve Servlet");
		req.getRequestDispatcher(ApproveDispatcher.process(req)).forward(req, res);
	}


}

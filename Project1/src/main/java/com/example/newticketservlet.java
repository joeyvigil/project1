package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class newticketservlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//req.getRequestDispatcher(ViewDispatcher.process(req)).forward(req, res);
		System.out.println("in newticket servlet");
		//System.out.println("amount: "+req.getParameter("amount")+" descip: "+req.getParameter("description")+ "type" +req.getParameter("type"));
		req.getRequestDispatcher(newticketDispatcher.process(req)).forward(req, res);
	}


}

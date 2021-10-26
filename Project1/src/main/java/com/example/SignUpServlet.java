package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5946372364030526799L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//req.getRequestDispatcher(ViewDispatcher.process(req)).forward(req, res);
		System.out.println("in doPost of signup servlet");
		System.out.println("username: "+req.getParameter("username")+" password: "+req.getParameter("password"));
		req.getRequestDispatcher(SignUpDispatcher.process(req)).forward(req, res);
		
	}


}

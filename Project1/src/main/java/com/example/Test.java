package com.example;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet{

	private static final long serialVersionUID = 6610630912692125218L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		System.out.println("in test servlet");
        resp.setContentType("text/plain");
        resp.getWriter().println("Servlet wrote this! (Test.java)");
    }
	
}
package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1236821328599116750L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("in doPost of Login Servlet");
		req.getRequestDispatcher(LoginDispatcher.process(req)).forward(req, res);
	}


}
////public ersreimb(double reimb_amount, String reimb_description, user author_fk, reimbtype type_fk) {
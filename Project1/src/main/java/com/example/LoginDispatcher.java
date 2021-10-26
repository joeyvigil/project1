package com.example;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.userDao;
import com.example.model.userrole;

public class LoginDispatcher {
	
	public static HibernateUtil hUtil = new HibernateUtil();
	public static userDao userd = new userDao(hUtil);

	public static String process(HttpServletRequest req) {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		
		if (userd.authenticate(username, password)) {
			
			req.getSession().setAttribute("currentuser", username);
			System.out.println("get param"+username);
			System.out.println("current user1 "+req.getSession().getAttribute("currentuser"));
			if (userd.rolefromusername(username).getRole().equals("Manager")) {
				return "/html/manager.html";
			}
			return "/html/employee.html";
		}
		System.out.println(userd.getAll());
		return "/html/failure.html";
	}
	


}

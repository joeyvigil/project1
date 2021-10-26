package com.example;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.userDao;
import com.example.dao.userroleDao;
import com.example.model.user;

public class SignUpDispatcher {
	public static HibernateUtil hUtil = new HibernateUtil();
	public static userDao userd = new userDao(hUtil);
	public static userroleDao urd = new userroleDao(hUtil);

	public static String process(HttpServletRequest req) {
		
		user u1= new user(req.getParameter("username"), req.getParameter("password"), req.getParameter("fname"), req.getParameter("lname"), req.getParameter("email"), urd.getemployee() );
		userd.insert(u1);
		return "/html/success2.html";
	}

}

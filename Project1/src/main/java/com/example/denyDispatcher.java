package com.example;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.ersreimbDao;
import com.example.dao.reimbstatusDao;
import com.example.dao.reimbtypeDao;
import com.example.dao.userDao;
import com.example.dao.userroleDao;
import com.example.model.ersreimb;

public class denyDispatcher {
	
	public static HibernateUtil hUtil = new HibernateUtil();
	public static reimbtypeDao rtd = new reimbtypeDao(hUtil);
	public static reimbstatusDao rsd = new reimbstatusDao(hUtil);
	public static userroleDao urd = new userroleDao(hUtil);
	public static userDao userd = new userDao(hUtil);
	public static ersreimbDao ersd = new ersreimbDao(hUtil);

	public static String process(HttpServletRequest req) {
		System.out.println("denying of id: " +req.getParameter("ticketid2"));
		System.out.println("denying of current user: " +req.getSession().getAttribute("currentuser"));
		ersreimb ersnew = ersd.approvedeny(userd.userfromusername((String)req.getSession().getAttribute("currentuser")), Integer.parseInt(req.getParameter("ticketid2")), rsd.getfromString("Denied"));
		ersd.update(ersnew);
		return "/html/manager.html";
	}

}

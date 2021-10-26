package com.example;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.ersreimbDao;
import com.example.dao.reimbstatusDao;
import com.example.dao.reimbtypeDao;
import com.example.dao.userDao;
import com.example.dao.userroleDao;
import com.example.model.ersreimb;
import com.example.model.reimbstatus;
import com.example.model.reimbtype;
import com.example.model.user;
import com.example.model.userrole;

public class newticketDispatcher {
	
	public static HibernateUtil hUtil = new HibernateUtil();
	public static reimbtypeDao rtd = new reimbtypeDao(hUtil);
	public static reimbstatusDao rsd = new reimbstatusDao(hUtil);
	public static userroleDao urd = new userroleDao(hUtil);
	public static userDao userd = new userDao(hUtil);
	public static ersreimbDao ersd = new ersreimbDao(hUtil);
	
	public static String process(HttpServletRequest req) {
		
		reimbtype rt;
		switch (req.getParameter("type").toString().toLowerCase()) {
		case "lodging":
			rt= rtd.typefromstring("LODGING");
			break;
		case "travel":
			rt= rtd.typefromstring("TRAVEL");
			break;
		case "food":
			rt= rtd.typefromstring("FOOD");
			break;
		default:
			rt= rtd.typefromstring("OTHER");
			break;
		}
		
		user u1= userd.userfromusername(req.getSession().getAttribute("currentuser").toString());
		
		ersreimb ers1 = new ersreimb(Double.parseDouble((req.getParameter("amount"))), req.getParameter("description"), u1, rt,rsd.getfromString("Pending"));
		ersd.insert(ers1);
		
		System.out.println(req.getSession().getAttribute("currentuser"));
		return "/html/success.html";
	}


}

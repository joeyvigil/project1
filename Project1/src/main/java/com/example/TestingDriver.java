package com.example;

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

public class TestingDriver {
	
	public static HibernateUtil hUtil = new HibernateUtil();
	public static reimbtypeDao rtd = new reimbtypeDao(hUtil);
	public static reimbstatusDao rsd = new reimbstatusDao(hUtil);
	public static userroleDao urd = new userroleDao(hUtil);
	public static userDao userd = new userDao(hUtil);
	public static ersreimbDao ersd = new ersreimbDao(hUtil);

	public static void main(String[] args) {
		init();
		System.out.println(rtd.getAll());
		System.out.println(rsd.getAll());
		System.out.println(urd.getAll());
		System.out.println(userd.getAll());
		System.out.println(ersd.getAll());
		
		System.out.println();
		hUtil.closeFactory();
	}
	
	public static void init() {
		//initialize variables
		reimbtype rt1= new reimbtype("LODGING");
		rtd.insert(rt1);
		reimbtype rt2= new reimbtype("TRAVEL");
		rtd.insert(rt2);
		reimbtype rt3= new reimbtype("FOOD");
		rtd.insert(rt3);
		reimbtype rt4= new reimbtype("OTHER");
		rtd.insert(rt4);
		
		reimbstatus rs1= new reimbstatus("Pending");
		rsd.insert(rs1);
		reimbstatus rs2= new reimbstatus("Denied");
		rsd.insert(rs2);
		reimbstatus rs3= new reimbstatus("Approved");
		rsd.insert(rs3);
		
		userrole ur1= new userrole("Employee");
		urd.insert(ur1);
		userrole ur2= new userrole("Manager");
		urd.insert(ur2);
		
		user u1= new user("monkey", "password", "Donkey", "Kong", "DK@gmail.com", ur1);
		userd.insert(u1);
		user u2= new user("mrjoey", "password", "joey", "vigil", "joeygvigil@gmail.com", ur2);
		userd.insert(u2);
		
		ersreimb ers1 = new ersreimb(200.0, "description is this", u1, rt4, rsd.getfromString("Pending"));
		ersd.insert(ers1);
		
		
		
		
		System.out.println("done");
	}

}

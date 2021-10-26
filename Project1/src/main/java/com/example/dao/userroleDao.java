package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.model.user;
import com.example.model.userrole;

public class userroleDao {
	
	private HibernateUtil hUtil;
	
	public userroleDao() {
		// TODO Auto-generated constructor stub
	}

	public userroleDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(userrole rt) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(rt);
		tx.commit();
		//ses.close();
	}
	
	public List<userrole> getAll(){
		Session ses = hUtil.getSession();
		List<userrole> cList =  ses.createQuery("from userrole", userrole.class).list();
		//ses.close();
		return cList;
	}
	
	public userrole getemployee() {
		List<userrole> userlist = getAll();
		for (userrole userrole : userlist) {
			if (userrole.getRole().equals("Employee")) {
				return userrole;
			}
		}
		return null;
	}

}

package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.model.reimbtype;
import com.example.model.user;

public class reimbtypeDao {
	
	private HibernateUtil hUtil;
	
	public reimbtypeDao() {
		// TODO Auto-generated constructor stub
	}

	public reimbtypeDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(reimbtype rt) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(rt);
		tx.commit();
		//ses.close();
	}
	
	public List<reimbtype> getAll(){
		Session ses = hUtil.getSession();
		
		List<reimbtype> cList =  ses.createQuery("from reimbtype", reimbtype.class).list();
		//ses.close();
		return cList;
	}
	
	public reimbtype typefromstring(String s1) {
		List<reimbtype> typelist = getAll();
		for (reimbtype reimbtype : typelist) {
			if (reimbtype.getType().equals(s1)) {
				return reimbtype;
			}
		}
		return null;
		
	}


}

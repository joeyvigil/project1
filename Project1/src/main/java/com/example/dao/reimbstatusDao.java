package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;

import com.example.model.reimbstatus;


public class reimbstatusDao {
	
	private HibernateUtil hUtil;
	
	public reimbstatusDao() {
		// TODO Auto-generated constructor stub
	}

	public reimbstatusDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(reimbstatus rs) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(rs);
		tx.commit();
		//ses.close();
	}
	
	public List<reimbstatus> getAll(){
		Session ses = hUtil.getSession();
		
		List<reimbstatus> cList =  ses.createQuery("from reimbstatus", reimbstatus.class).list();
		//ses.close();
		return cList;
	}
	
	public reimbstatus getfromString(String str) {
		List<reimbstatus> allrb= getAll();
		for (reimbstatus reimbstatuss : allrb) {
			if (reimbstatuss.getStatus().equals(str)) {
				System.out.println("ingetfromstring of reimbstatus dao:"+ reimbstatuss.getStatus());
				return reimbstatuss;
			}
		}
		return null;

	}

}

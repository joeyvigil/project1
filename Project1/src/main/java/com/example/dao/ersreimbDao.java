package com.example.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.model.ersreimb;
import com.example.model.reimbstatus;
import com.example.model.user;

public class ersreimbDao {
	
private HibernateUtil hUtil;
	
	public ersreimbDao() {
		// TODO Auto-generated constructor stub
	}

	public ersreimbDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(ersreimb user1) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(user1);
		tx.commit();
		//ses.close();
	}
	
	public void update() {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		tx.commit();
		//ses.close();
	}
	
	public void update(ersreimb vill) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(vill);
		tx.commit();
		//ses.close();
	}
	
	public List<ersreimb> getAll(){
		Session ses = hUtil.getSession();
		List<ersreimb> cList =  ses.createQuery("from ersreimb", ersreimb.class).list();
		for (ersreimb ersreimbs : cList) {
			System.out.println(ersreimbs);
		}
		System.out.println(cList);
		
		//ses.close();
		return cList;
	}
	
//	private static <T> List<T> loadAllData(Class<T> type, Session session) {
//	    CriteriaBuilder builder = session.getCriteriaBuilder();
//	    CriteriaQuery<T> criteria = builder.createQuery(type);
//	    criteria.from(type);
//	    List<T> data = session.createQuery(criteria).getResultList();
//	    return data;
//	  }
	
	public ersreimb approvedeny(user approver,int id ,reimbstatus rs) {
		List<ersreimb> allers =getAll();
		for (ersreimb ersreimbs : allers) {
			if(ersreimbs.getReimb_id()==id){
				System.out.println("in approve/deny"+approver + id +rs);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
				System.out.println("getting current time for new approval request: "+dtf.format(now)); 
				ersreimbs.setReimb_resolved(dtf.format(now));
				ersreimbs.setResolver_fk(approver);
				ersreimbs.setStatus_fk(rs);
				System.out.println("returning this");
				return ersreimbs;
			}
		}
		return null;
		
	}
	


	
	 

}

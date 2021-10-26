package com.example.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.model.user;
import com.example.model.userrole;

public class userDao {
	
private HibernateUtil hUtil;
	
	public userDao() {
		// TODO Auto-generated constructor stub
	}

	public userDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(user user1) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(user1);
		tx.commit();
		//ses.close();
	}
	
	public List<user> getAll(){
		
		Session ses = hUtil.getSession();
		
		List<user> cList =  ses.createQuery("from user", user.class).list();
		//ses.close();
		return cList;
	}
	
	//returns true if valid username + password
	public boolean authenticate(String username,String password) {
		List<user> userlist = getAll();
		for (user users : userlist) {
			if(users.getUser_name().equals(username)) {
				if (users.getUser_pass().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//returns type from username
	public userrole rolefromusername(String username) {
		List<user> userlist = getAll();
		for (user users : userlist) {
			if (users.getUser_name().equals(username)) {
				return users.getUserrole_fk();
			}
		}
		return null;
	}
	
	public user userfromusername(String username) {
		List<user> userlist = getAll();
		for (user users : userlist) {
			if (users.getUser_name().equals(username)) {
				return users;
			}
		}
		return null;
	}
	
	

}

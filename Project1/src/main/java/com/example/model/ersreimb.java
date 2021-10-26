package com.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.HibernateUtil;
import com.example.dao.ersreimbDao;
import com.example.dao.reimbstatusDao;
import com.example.dao.reimbtypeDao;
import com.example.dao.userDao;
import com.example.dao.userroleDao;



@Entity
@Table(name="ersreimb")
public class ersreimb {
	
	
	@Id 
	@Column(name="reimb_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimb_id;
	
	@Column(name="reimb_amount")
	private double reimb_amount;
	
	@Column(name="reimb_submit")
	private String reimb_submit;
	
	@Column(name="reimb_resolved")
	private String reimb_resolved;
	 
	@Column(name="reimb_description")
	private String reimb_description;
	
	//author
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="author_fk")
	private user author_fk;
	//resolver
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="resolver_fk")
	private user resolver_fk;
	//status
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="status_fk")
	private reimbstatus status_fk;
	//type
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="type_fk")
	private reimbtype type_fk;
	
	public ersreimb() {
		// TODO Auto-generated constructor stub
	}

	public ersreimb(double reimb_amount, String reimb_submit, String reimb_resolved,
			String reimb_description, user author_fk, user resolver_fk, reimbstatus status_fk, reimbtype type_fk) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submit = reimb_submit;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.author_fk = author_fk;
		this.resolver_fk = resolver_fk;
		this.status_fk = status_fk;
		this.type_fk = type_fk;
	}
	
	
	//for initial creation
	public ersreimb(double reimb_amount, String reimb_description, user author_fk, reimbtype type_fk, reimbstatus status_fk) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("getting current time for new ers request: "+dtf.format(now)); 
		this.status_fk = status_fk;
		this.reimb_submit=dtf.format(now);
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.author_fk = author_fk;
		this.type_fk = type_fk;
	}
;
	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_submit() {
		return reimb_submit;
	}

	public void setReimb_submit(String reimb_submit) {
		this.reimb_submit = reimb_submit;
	}

	public String getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public user getAuthor_fk() {
		return author_fk;
	}

	public void setAuthor_fk(user author_fk) {
		this.author_fk = author_fk;
	}

	public user getResolver_fk() {
		return resolver_fk;
	}

	public void setResolver_fk(user resolver_fk) {
		this.resolver_fk = resolver_fk;
	}

	public reimbstatus getStatus_fk() {
		return status_fk;
	}

	public void setStatus_fk(reimbstatus status_fk) {
		this.status_fk = status_fk;
	}

	public reimbtype getType_fk() {
		return type_fk;
	}

	public void setType_fk(reimbtype type_fk) {
		this.type_fk = type_fk;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	@Override
	public String toString() {
		return "ersreimb [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submit=" + reimb_submit
				+ ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description + ", author_fk="
				+ author_fk + ", resolver_fk=" + resolver_fk + ", status_fk=" + status_fk + ", type_fk=" + type_fk
				+ "]";
	}
	
	

}

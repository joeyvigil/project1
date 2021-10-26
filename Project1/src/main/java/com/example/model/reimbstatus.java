package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimbstatus")
public class reimbstatus {
	
	@Id 
	@Column(name="statusid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusid;
	
	@Column(name="status", unique=true, nullable=false)
	private String status;
	
	public reimbstatus() {
	}

	public reimbstatus(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusid() {
		return statusid;
	}

	@Override
	public String toString() {
		return "reimbstatus [statusid=" + statusid + ", status=" + status + "]";
	}
	
	
	
}

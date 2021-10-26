package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userrole")
public class userrole {
	
	@Id 
	@Column(name="roleid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleid;
	
	@Column(name="role", unique=true, nullable=false)
	private String role;

	public userrole() {
	}

	public userrole(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRoleid() {
		return roleid;
	}

	@Override
	public String toString() {
		return "userrole [roleid=" + roleid + ", role=" + role + "]";
	}
	
	
}

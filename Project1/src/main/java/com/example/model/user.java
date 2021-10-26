package com.example.model;

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

@Entity
@Table(name="users")
public class user {
	
	@Id 
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	@Column(name="user_name", nullable=false, unique = true)
	private String user_name;
	
	@Column(name="user_pass")
	private String user_pass;
	
	@Column(name="user_first")
	private String user_first;
	
	@Column(name="user_last")
	private String user_last;
	
	@Column(name="user_email")
	private String user_email;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="userrole_fk")
	private userrole userrole_fk;
	
	public user() {
		// TODO Auto-generated constructor stub
	}

	public user(String user_name, String user_pass, String user_first, String user_last, String user_email, userrole userrole_fk) {
		super();
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.user_first = user_first;
		this.user_last = user_last;
		this.user_email = user_email;
		this.userrole_fk = userrole_fk;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_first() {
		return user_first;
	}

	public void setUser_first(String user_first) {
		this.user_first = user_first;
	}

	public String getUser_last() {
		return user_last;
	}

	public void setUser_last(String user_last) {
		this.user_last = user_last;
	}


	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public userrole getUserrole_fk() {
		return userrole_fk;
	}

	public void setUserrole_fk(userrole userrole_fk) {
		this.userrole_fk = userrole_fk;
	}

	public int getUserid() {
		return userid;
	}

	@Override
	public String toString() {
		return "user [userid=" + userid + ", user_name=" + user_name + ", user_pass=" + user_pass + ", user_first="
				+ user_first + ", user_last=" + user_last + ", user_email=" + user_email + ", userrole_fk="
				+ userrole_fk + "]";
	}

	


}

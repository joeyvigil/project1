package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimbtype")
public class reimbtype {
	
	@Id 
	@Column(name="typeid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeid;
	
	@Column(name="type", unique=true, nullable=false)
	private String type;
	
	public reimbtype() {
	}

	public reimbtype(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTypeid() {
		return typeid;
	}

	@Override
	public String toString() {
		return "reimbtype [typeid=" + typeid + ", type=" + type + "]";
	}
	
	
}

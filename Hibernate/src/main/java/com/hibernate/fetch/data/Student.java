package com.hibernate.fetch.data;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	@Id
	@Column(name="s_id")
	private int sid;
	
	@Column(name="s_name")
	private String sname;
	
	@Column(name="s_course")
	private String scourse;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScourse() {
		return scourse;
	}
	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scourse=" + scourse + "]";
	}
	public Student(int sid, String sname, String scourse) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.scourse = scourse;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

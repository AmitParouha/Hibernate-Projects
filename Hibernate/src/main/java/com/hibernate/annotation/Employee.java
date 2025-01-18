package com.hibernate.annotation;

import java.util.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	private int eid;
	
	@Column(name="e_name")
	private String name;
	
	@Column(name="e_salary")
	private double salary;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Lob
	private byte[] image;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", salary=" + salary + ", dob=" + dob + ", image="
				+ Arrays.toString(image) + "]";
	}
	public Employee(int eid, String name, double salary, Date dob, byte[] image) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.image = image;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

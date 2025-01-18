package com.hibernate.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("emp")
@Scope("prototype")
@Entity
public class Employees{
	
	@Id
	@Column(name="Emp_No")
	private int empNo;
	
	@Column(name="E_name")
	private String EName;
	
	@OneToOne
	private Department deptNo;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEName() {
		return EName;
	}

	public void setEName(String eName) {
		EName = eName;
	}

	public Department getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Department deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employees [empNo=" + empNo + ", EName=" + EName + ", deptNo=" + deptNo + "]";
	}

	public Employees(int empNo, String eName, Department deptNo) {
		super();
		this.empNo = empNo;
		EName = eName;
		this.deptNo = deptNo;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

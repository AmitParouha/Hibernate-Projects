package com.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component("service")
public class EmployeeService {
	SessionFactory factory;
	Session session ;
	{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	
	public void insert(Employees emp) {
		Transaction tx =  session.beginTransaction();
		System.out.println(session.save(emp)+" Successfully saved");
		tx.commit();
	}
	
	public void insertDept(Department dept) {
		Transaction tx =  session.beginTransaction();
		System.out.println(session.save(dept)+" Successfully saved");
		tx.commit();
	}
	
	public Employees getEmployee(int id) {
		return session.get(Employees.class, id);
	}

	public Department getDept(int id) {
		return session.get(Department.class, id);
	}
}

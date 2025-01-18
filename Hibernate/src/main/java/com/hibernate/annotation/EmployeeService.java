package com.hibernate.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeService {
	SessionFactory factory;
	Session session;
	Transaction tx;
	{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
	}
	public void insert(Employee employee) {
		System.out.println(session.save(employee));
		tx.commit();
		System.out.println("Data successfully inserted");	
	
	}
	
	@Override
	protected void finalize() {
		
		session.close();
	}
	
}

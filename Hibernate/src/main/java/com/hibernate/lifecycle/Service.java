package com.hibernate.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {

	private SessionFactory factory;
	private Session session;
	
	{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	
	public String addMobile(Mobile mobile) {
		Transaction tx = session.beginTransaction();
		session.save(mobile);
		System.out.println(mobile);
		mobile.setPrice("20000");
		tx.commit();
		return "Mobile successfully saved";
	}
	
	public Mobile getMobile(String name) {
		return session.get(Mobile.class, name);
	}
	
}

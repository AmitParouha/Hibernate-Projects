package com.hibernate.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeacherService {

	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	
	{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	
	public void insert(Teacher teacher) {
		tx = session.beginTransaction();
		System.out.println(session.save(teacher)+" Successfully inserted");
		tx.commit();
	}
	
	public Teacher getTeacher(int id) {
		return session.get(Teacher.class, id);
	}
}

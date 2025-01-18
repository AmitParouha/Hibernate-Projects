package com.hibernate.fetch.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StudentDao {
	SessionFactory factory;
	Session session;
	Transaction tx;
	public StudentDao(){
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	
	public int insert(Student student) {
		tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		return 1;
	}
	
	public Student getStudent(int id) {
		return session.get(Student.class, id);
	}
}

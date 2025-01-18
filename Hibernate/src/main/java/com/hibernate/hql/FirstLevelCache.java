package com.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fetch.data.Student;
public class FirstLevelCache {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Student s = session.get(Student.class, 201);
		System.out.println("\n___________________________________________________\n");
		System.out.println(s);
		System.out.println(s); // for fetching this hibernate does not fire any db query
		
		factory.close();
		session.close();
	}
}

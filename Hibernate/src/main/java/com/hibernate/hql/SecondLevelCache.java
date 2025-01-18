package com.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fetch.data.Student;

public class SecondLevelCache {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session1 = factory.openSession();

		Student s = session1.get(Student.class, 201);
		System.out.println("\n___________________________________________________\n");
		System.out.println(s);
		session1.close(); // Session closed
		
		Session session2 = factory.openSession();
		System.out.println(session2.get(Student.class, 201));
		session2.close();
		factory.close();
		
	}
}

package com.hibernate.xml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.fetch.data.Student;

public class PersonHandler {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Person p1 = new Person("Subham Tiwari", 28, "Big Data Engeenier");
		Person p2 = new Person("Suraj Gaur", 24, ".NET Developer");
		Person p3 = new Person("AmitParouha", 23, "Java FSE");
		Person p4 = new Person("Neha Chaudhary", 26, "Free");
		Person p5 = new Person("Shivendra Gupta", 24, "Java FSE");
		
		Transaction tx = session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		tx.commit();
		
		Query<Person> query = session.createQuery("From Person");
		List<Person> person = query.getResultList(); 
		
		System.out.println("__________________________________________________");
		for(Person p : person) {
			System.out.println(p);
		}
		
		session.close();
		factory.close();
		
	}
}

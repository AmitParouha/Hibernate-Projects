package com.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.fetch.data.Student;


public class Pegination {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Query<Student> query = session.createQuery("From Student");
		query.setFirstResult(3);  // counting always start from 0
		query.setMaxResults(8);   // maximum rows will be shown in a single page
		
		List<Student> student = query.getResultList();
		for(Student s: student) {
			System.out.println(s);
		}
	
		factory.close();
		session.close();
	}
}

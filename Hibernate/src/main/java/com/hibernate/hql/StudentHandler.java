package com.hibernate.hql;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.fetch.data.Student;

public class StudentHandler {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	private static Session session = factory.openSession();
	public static void main(String[] args) {
		getByName("Sachin");
		getByNameAndCourse("Amit Parouha", "MCA");
		getByNameOrCourse("Amit Parouha", "MCA");
		deleteByName("Sachin");
		updateById(201,"Abhijeet","BTECH" );

		factory.close();
		session.close();
	}
	
	public static void getByName(String name) {
		String query = "from Student where sname=:name";
		Query q = session.createQuery(query);
		q.setParameter("name", name);
		List<Student> student = q.getResultList();
		for(Student s: student) {
			System.out.println(s);
		}
	}
	
	public static void getByNameAndCourse(String name,String course) {
		String query = "from Student where sname=:name and scourse=:course";
		Query q = session.createQuery(query);
		q.setParameter("name", name);
		q.setParameter("course", course);
		List<Student> student = q.getResultList();
		for(Student s: student) {
			System.out.println(s);
		}
	}
	
	public static void getByNameOrCourse(String name,String course) {
		String query = "from Student where sname=:name or scourse=:course";
 		Query q = session.createQuery(query);
		q.setParameter("name", name);
		q.setParameter("course", course);
		List<Student> student = q.getResultList();
		for(Student s: student) {
			System.out.println(s);
		}
	}
	
	public static void deleteByName(String name) {
		String query = "delete from Student where sname=:name";
		Query q = session.createQuery(query);
		Transaction tx = session.beginTransaction();
		q.setParameter("name", name);
		int row = q.executeUpdate();
		tx.commit();
		System.out.println(row+" deleted updated");
	}
	
	public static void updateById(int id, String name, String course) {
		String query = "update Student set sname=:name, scourse=:course where sid=:id";
		
		Query q = session.createQuery(query);
		q.setParameter("name", name);
		q.setParameter("course", course);
		q.setParameter("id", id);
		Transaction tx = session.beginTransaction();
		int row = q.executeUpdate();
		tx.commit();
		System.out.println(row+" rows updated");
	}
}

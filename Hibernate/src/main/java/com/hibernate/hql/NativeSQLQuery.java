package com.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import com.hibernate.fetch.data.Student;

public class NativeSQLQuery {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		NativeQuery query = session.createSQLQuery("Select *From Student");
		
		List<Object[]> student = query.getResultList();
		System.out.println("\n\n");
		for (Object[] s : student) {
			System.out.println(s[0]+"  "+s[1]+"\t"+s[2]);
		}

		factory.close();
		session.close();
	}
}

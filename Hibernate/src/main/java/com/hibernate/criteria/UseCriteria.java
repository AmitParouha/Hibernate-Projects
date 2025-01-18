package com.hibernate.criteria;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.fetch.data.Student;

public class UseCriteria {
	
	private static Session session = new Configuration().configure().buildSessionFactory().openSession();
	private static Criteria criteria = session.createCriteria(Student.class);

	public static void printList(List<Student> students) {
		System.out.println("\n___________________________________________________\n");
		for (Student s : students) {
			System.out.println(s.getSid() + "\t" + s.getSname() + "\t" + s.getScourse());
		}
	}
	
	public static void main(String[] args) {

		printList(getAll());
		printList(studentGreaterThan(205));
		printList(studentBetween(204, 208));
		printList(findByCourse("MCA"));
		printList(findByNameLike("a"));
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(201);
		l.add(204);
		l.add(207);
		l.add(294);
		printList(findByStudentIn(l));

		session.close();

	}

	public static List<Student> getAll() {
		return criteria.list();
	}

	public static List<Student> studentGreaterThan(int id) {
		criteria.add(Restrictions.gt("sid", id));
		return criteria.list();
	}

	public static List<Student> studentBetween(int id1, int id2) {
		criteria.add(Restrictions.between("sid", id1, id2));
		return criteria.list();
	}
	
	public static List<Student> findByCourse(String course) {
		criteria.add(Restrictions.eq("scourse", course));
		return criteria.list();
	}
	
	public static List<Student> findByNameLike(String name) {
		criteria.add(Restrictions.ilike("sname", "%"+name+"%"));
		return criteria.list();
	}
	
	public static List<Student> findByStudentIn(List<Integer> id) {
		criteria.add(Restrictions.in("sid", id));
		return criteria.list();
	}
	
	
}

package com.hibernate.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.ManyToOne.Answer;
import com.hibernate.ManyToOne.Question;

public class Cascade {
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public static Session session = factory.openSession();
	public static void main(String[] args) {
		
		Question quetion = new Question();
		quetion.setId(2);
		quetion.setQuestion("What is Hibernate");
		
		Answer answer1 = new Answer();
		answer1.setA_id(104);
		answer1.setAnswer("Hibernate is a ORM tool");
		answer1.setQuestion(quetion);
		
		Answer answer2 = new Answer();
		answer2.setA_id(105);
		answer2.setAnswer("Hibernate is a Java Framework");
		answer2.setQuestion(quetion);
		
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(answer1);
		answers.add(answer2);
		
		quetion.setAnswer(answers);
		
		Transaction tx = session.beginTransaction();
		//session.save(quetion);
		//session.delete(quetion);
		tx.commit();
		
		factory.close();
		session.close();
	}
}

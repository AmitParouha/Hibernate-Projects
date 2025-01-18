package com.hibernate.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component("service")
public class QuestionService {
	
	SessionFactory factory;
	Session session;
	{
		factory = new Configuration().configure().buildSessionFactory();		
		session = factory.openSession();
	}
	
	public String saveQuestion(Question question) {
		Transaction tx = session.beginTransaction();
		session.save(question);
		tx.commit();
		return "Question Saved";
		
	}
	
	public String saveAnswer(Answer answer) {
		Transaction tx = session.beginTransaction();
		session.save(answer);
		tx.commit();
		return "Answer Saved";
	}
	
	public Question getQuestion(int id) {
		return session.get(Question.class, id);
	}

	public Answer getAnswer(int id) {
		return session.get(Answer.class, id);
	}
}

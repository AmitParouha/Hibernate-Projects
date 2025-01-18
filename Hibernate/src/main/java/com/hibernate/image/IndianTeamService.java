package com.hibernate.image;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IndianTeamService {
	
	private SessionFactory factory;
	private Session session;
	
	{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	
	public void insert(IndianTeam player) {
		System.out.println(session.save(player));
		session.beginTransaction().commit();
		System.out.println("Player successfully Saved");
	}
	
	@Override
	protected void finalize() {
		session.close();
		factory.close();
	}
}

package com.hibernate.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component("service")
public class Service {
	
	private SessionFactory factory;
	private Session session;
	
	{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession(); 
	}
	
	public String addEmployee(Employee employee) {
		Transaction tx =  session.beginTransaction();
		session.save(employee);
		tx.commit();
		return "Employee successfully added";
	}
	
	public String addProject(Project project) {
		Transaction tx =  session.beginTransaction();
		session.save(project);
		tx.commit();
		return "Project details successfully added";
	}
	
	public Employee getEmployee(int id) {
		return session.get(Employee.class, id);
	}
	
	public Project getProject(int id) {
		return session.get(Project.class, id);
	}
}

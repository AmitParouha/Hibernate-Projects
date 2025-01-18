package com.hibernate.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Handler {
	
	public static void main(String ...strings) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Service service = context.getBean("service",Service.class);
		
		Employee employee1 = context.getBean("employee",Employee.class);
		employee1.setId(201);
		employee1.setName("Amit Parouha");
		
		Employee employee2 = context.getBean("employee",Employee.class);
		employee2.setId(202);
		employee2.setName("Sumit Mishra");
		
		
		//Project Objects
		
		Project project1 = context.getBean("project",Project.class);
		project1.setId(101);
		project1.setName("Bank Management System");
		
		
		Project project2 = context.getBean("project",Project.class);
		project2.setId(102);
		project2.setName("E-Mart");
		
		
		List<Project> p1 = new ArrayList<Project>();
		p1.add(project1);
		p1.add(project2);
		
		List<Employee> emp1 = new ArrayList<Employee>();
		emp1.add(employee1);
		emp1.add(employee2);
		
		employee1.setProject(p1);
		project2.setEmployee(emp1);
		
		service.addProject(project1);
		service.addProject(project2);
		
		service.addEmployee(employee1);
		service.addEmployee(employee2);
		
	}
}

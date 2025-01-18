package com.hibernate.mapping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseEmployees {
	public static void main(String ...strings ) {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.hibernate.mapping.Config.class);
	
		Employees e1 = context.getBean("emp",Employees.class);
		Department d1 = context.getBean("dept",Department.class);
	
		d1.setDeptno(10);
		d1.setDname("Accountant");
		d1.setLocation("Pune");
		
		e1.setEmpNo(201);
		e1.setDeptNo(d1);
		e1.setEName("Rahul");
		
		EmployeeService service = context.getBean("service",EmployeeService.class);

		//service.insertDept(d1); these details already inserted in database
		//service.insert(e1); these details already inserted in database
		
		e1.setEmpNo(202);
		e1.setDeptNo(d1);
		e1.setEName("Abhijeet");
		
		//service.insert(e1); these details already inserted in database
		
		for(int i=201; i<=202; i++) {
			e1 = service.getEmployee(i);
			d1 = e1.getDeptNo();
			System.out.println("Employee Details ");
			System.out.println("=======================");
			System.out.println(d1.getDeptno());
			System.out.println(e1.getEmpNo());
			System.out.println(e1.getEName());
			System.out.println(d1.getDname());
			System.out.println(d1.getLocation());
			System.out.println("________________________________________________");
		}
	}
}

package com.hibernate.annotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class UseEmployee {

	public static void main(String[] args) throws IOException{
		
		EmployeeService service = new EmployeeService();
		Employee employee = new Employee();
		
		employee.setEid(201);
		employee.setName("Amit Kumar Parouha");
		employee.setSalary(30000);
		employee.setDob(new Date());
		
		
		
		
		
		// image insertion process
		FileInputStream fis = new FileInputStream("src/main/java/amit.jpeg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		
		employee.setImage(data);
		service.insert(employee);
		
		fis.close();
	}

}

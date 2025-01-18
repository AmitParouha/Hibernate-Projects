package com.hibernate.fetch.data;

import java.util.Scanner;

public class UseStudent {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		Student student ;
		StudentDao service = new StudentDao();
		
		while(true) {
			System.out.println("1. Insert \n2. Update \n3. Delete \n4. Select \n5. Exit");
			System.out.print("Enter your choice: ");
			int choice = kb.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter student ID: ");
					student = new Student();
					student.setSid(kb.nextInt());
					kb.nextLine();
					System.out.println("Enter student name: ");
					student.setSname(kb.nextLine());
					System.out.println("Enter student course: ");
					student.setScourse(kb.nextLine());
					service.insert(student); 
					break;
					
				case 2:
					break;
				
				case 3:
					break;	 
		
				case 4:
					System.out.println("Enter student ID");	
					student = new Student();
					student = service.getStudent(kb.nextInt());	   
					System.out.println(student);
					break;
					
				case 5:
					break;
			}
			if(choice==5) {
				System.out.println("Thanks for using the app");
				break;
			}
		}
		kb.close();
	}
}

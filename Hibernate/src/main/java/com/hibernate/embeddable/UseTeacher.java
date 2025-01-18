package com.hibernate.embeddable;

public class UseTeacher {

	public static void main(String[] args) {
		
		TeacherService service = new TeacherService();
		
		Address address = new Address();
		address.setStreet("Indrapuri Sector-A");
		address.setCity("Bhopal");
		address.setState("Madhya Pradesh");
		
		Teacher t = new Teacher();
		t.setId(101);
		t.setName("Harish Mishra");
		t.setAddress(address);
		
		service.insert(t);
		
		Address address1 = new Address();
		address1.setStreet("Indrapuri Sector-B");
		address1.setCity("Bhopal");
		address1.setState("Madhya Pradesh");
		
		Teacher t1 = new Teacher();
		t1.setId(102);
		t1.setName("Vinay Panday");
		t1.setAddress(address1);
		
		service.insert(t1);

	}

}

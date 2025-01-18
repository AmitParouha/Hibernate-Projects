package com.hibernate.lifecycle;

public class MobileHandler {

	public static void main(String...strings) {
		
		Service service = new Service();
		
		Mobile mobile1 = new Mobile();
		mobile1.setName("Vivo");
		mobile1.setPrice("15000");
		mobile1.setVersion("v19");
		service.addMobile(mobile1);
		
		Mobile mobile2 = new Mobile();
		mobile2.setName("Oppo");
		mobile2.setPrice("18000");
		mobile2.setVersion("5.2.3");
		service.addMobile(mobile2);
		
		
		mobile1 = service.getMobile("Oppo");
		mobile2 = service.getMobile("Vivo");
		
		System.out.println("__________________________________________________");
		
		System.out.println(mobile1);
		System.out.println(mobile2);
		
	}
}

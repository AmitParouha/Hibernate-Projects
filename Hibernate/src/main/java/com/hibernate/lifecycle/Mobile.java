package com.hibernate.lifecycle;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mobile {
	
	@Id
	private String name;
	private String version;
	private String price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Mobile(String name, String version, String price) {
		super();
		this.name = name;
		this.version = version;
		this.price = price;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Mobile [name=" + name + ", version=" + version + ", price=" + price + "]";
	}
	
	
	
}

package com.technocrat.springboot.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="phones")
public class Phone {

	@Id
	private String id;
	private String name;
	private String phone;
	
	public Phone() {
		
	}

	public Phone(String id, String phone) {
		super();
		this.id = id;
		this.phone = phone;
	}
	
	//Getters & Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

package com.technocrat.springboot.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="personindex", type="persontype")
public class Person {
	
	@Id
	private String ssn;
	private String name;
	private String email;
	private String gender;
	
	public Person() {
		
	}
	
	public Person(String ssn, String name, String email, String gender) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	//getters & setters
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

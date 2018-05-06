package com.technocrat.springboot.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technocrat.springboot.entities.Person;
import com.technocrat.springboot.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	//For Debug Purpose
	@RequestMapping("/connectioninfo")
	public Map<String, String> printConnectionInfo() {
		return service.printElasticSearchInfo();
	}
	
	@RequestMapping(value="/persons")
	public List<Person> getAllPersons() {
		return service.getAllPersons();
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public boolean addPerson(@RequestBody Person person) {
		return service.addPerson(person);
	}
	
	@RequestMapping(value="/persons/{id}", method=RequestMethod.PUT)
	public boolean updatePerson(@RequestBody Person person, @PathVariable String id) {
		return service.addPerson(person);
	}
	
	@RequestMapping(value="/persons/{id}", method=RequestMethod.DELETE)
	public boolean deletePerson(@PathVariable String id) {
		return service.deletePerson(id);
	}
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	public List<Person> getByName(@RequestParam("name") String name) {
		return service.getByName(name);
	}
	
	@RequestMapping(value="/person/gender", method=RequestMethod.GET)
	public List<Person> getByGender(@RequestParam("gender") String gender) {
		return service.getByGender(gender);
	}
	
	
}

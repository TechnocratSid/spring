package com.technocrat.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import com.technocrat.springboot.entities.Person;
import com.technocrat.springboot.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ElasticsearchOperations es;
	
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		personRepository.findAll().forEach(persons::add);
		return persons;
	}
	
	public boolean addPerson(Person person) {
		try {
			personRepository.save(person);
		} catch(Exception es) {
			return false;
		}
		return true;
	}
	
	
	//TODO: refine it
	public boolean deletePerson(String id) {
		try {
			personRepository.delete(getAllPersons().stream().filter(p -> p.getSsn().equals(id)).findFirst().get());
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public List<Person> getByGender(String gender) {
		return personRepository.findByGender(gender);
	}
	
	public List<Person> getByName(String name) {
		return personRepository.findByName(name);
	}
	
	public Map<String, String> printElasticSearchInfo() {
        return es.getClient().settings().getAsMap();    
	}

}

package com.technocrat.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;

import com.technocrat.springboot.entities.Phone;
import com.technocrat.springboot.repositories.PhoneRepository;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private Neo4jOperations neo4j;
	
	public List<Phone> getAllPhones() {
		List<Phone> phones = new ArrayList<>();
		phoneRepository.findAll().forEach(phones::add);
		return phones;
	}
	
	public void printNeo4jInfo() {
		
	}
	
	
}

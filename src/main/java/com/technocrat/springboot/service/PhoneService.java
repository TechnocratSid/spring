package com.technocrat.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.technocrat.springboot.entities.Phone;
import com.technocrat.springboot.repositories.PhoneRepository;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	//using MongoTemplate which is the implementation of MongoOperations to debug connection info
	@Autowired
	private MongoTemplate mongo;
	
	public List<Phone> getAllPhones() {
		List<Phone> phones = new ArrayList<>();
		phoneRepository.findAll().forEach(phones::add);
		return phones;
	}
	
	public boolean addPhone(Phone phone) {
		try {
			phoneRepository.save(phone);
		} catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	//TODO: refine it as well
	public boolean deletePhone(String id) {
		try {
			phoneRepository.delete(getAllPhones().stream().filter(p -> p.getId().equals(id)).findFirst().get());
		} catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public List<Phone> getByName(String name) {
		return phoneRepository.findByName(name); 
	}
	
	public List<Phone> getByPhone(String phone) {
		return phoneRepository.findByPhone(phone);
	}
	
	// for debug info
	public Map<String, String> printMongoInfo() {
		Map<String, String> connectionInfo = new HashMap<>();
		connectionInfo.put("address", mongo.getDb().getMongo().getAddress().toString());
		connectionInfo.put("connection", mongo.getDb().getMongo().getConnectPoint());
		return connectionInfo;
	}
	
	
}

package com.technocrat.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.technocrat.springboot.entities.Phone;

public interface PhoneRepository extends MongoRepository<Phone, String> {
	
	List<Phone> findByPhone(String phone);
	
	List<Phone> findByName(String name);

}

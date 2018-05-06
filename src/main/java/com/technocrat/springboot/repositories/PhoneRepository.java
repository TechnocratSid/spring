package com.technocrat.springboot.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.technocrat.springboot.entities.Phone;

public interface PhoneRepository extends Neo4jRepository<Phone, String> {

}

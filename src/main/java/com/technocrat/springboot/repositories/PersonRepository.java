package com.technocrat.springboot.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.technocrat.springboot.entities.Person;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
	
	List<Person> findByName(String name);
	
	@Query("{\"bool\": {\"must\": [{\"match\": {\"gender\": \"?0\"}}]}}")
	List<Person> findByGender(String gender);

}

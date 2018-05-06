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

import com.technocrat.springboot.entities.Phone;
import com.technocrat.springboot.service.PhoneService;

@RestController
public class PhoneController {

	@Autowired
	private PhoneService service;
	
	//For Debug Purpose
	@RequestMapping("phones/connectioninfo")
	public Map<String, String> printConnectionInfo() {
		return service.printMongoInfo();
	}
	
	@RequestMapping(value="/phones")
	public List<Phone> getAllPhones() {
		return service.getAllPhones();
	}
	
	@RequestMapping(value="/phones", method=RequestMethod.POST)
	public boolean addPhone(@RequestBody Phone phone) {
		return service.addPhone(phone);
	}
	
	@RequestMapping(value="/phones/{id}", method=RequestMethod.PUT)
	public boolean updatePhone(@RequestBody Phone phone, @PathVariable String id) {
		return service.addPhone(phone);
	}
	
	@RequestMapping(value="/phones/{id}", method=RequestMethod.DELETE)
	public boolean deletePhone(@PathVariable String id) {
		return service.deletePhone(id);
	}
	
	@RequestMapping(value="/phone/getbyname", method=RequestMethod.GET)
	public List<Phone> getByName(@RequestParam("name") String name) {
		return service.getByName(name);
	}
	
	@RequestMapping(value="/phone/getbyphone", method=RequestMethod.GET)
	public List<Phone> getByPhone(@RequestParam("phone") String phone) {
		return service.getByPhone(phone);
	}

}
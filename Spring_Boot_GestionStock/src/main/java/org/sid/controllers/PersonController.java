package org.sid.controllers;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.sid.entities.Person;
import org.sid.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping(value = "/v1")
public class PersonController {
	
	@Autowired
	public PersonRepository personRepo;
	
	@PostMapping(value = "/create")
	public Person createPerson(@RequestBody Person person) {
		return personRepo.save(person);
		
	}
	
	
	@PutMapping(value = "/update/{id}")
	public Person updatePerson( @PathVariable Long id,  @RequestBody Person person) {
		
		if(id!=null) {
			Person p = personRepo.findById(id).orElse(null);
		if(p!=null) {
			person.setIdPerson(id);
		    return personRepo.save(person);
		}
		}
	return null;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deletePerson (@PathVariable Long id) {
		
        if(id!=null) {
			Person person = personRepo.findById(id).orElse(null);
		if(person!=null) {	
		    personRepo.deleteById(id);
	}
		
	}
	
	
	}
	
	@GetMapping(value = "/all")
	public java.util.List<Person> getAll(){
		
	return personRepo.findAll();
	}
	
	@GetMapping(value = "/all/name/{name}")
	public java.util.List<Person> getByName(@PathVariable String name){
		return personRepo.getByName(name);
		
	}
}

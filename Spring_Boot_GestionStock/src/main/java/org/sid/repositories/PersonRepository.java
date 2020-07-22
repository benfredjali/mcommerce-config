package org.sid.repositories;

import java.util.List;

import org.sid.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

	public List<Person> getByName(String name); 
}

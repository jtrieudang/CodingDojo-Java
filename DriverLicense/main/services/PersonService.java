package com.codingdojo.driverlicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driverlicense.models.Person;
import com.codingdojo.driverlicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;			
	}

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> findAll(){
		return personRepository.findAll();
	}

	public Person findPerson(Long id) {
		Optional<Person> findPerson = personRepository.findById(id);
		if(findPerson.isPresent()) {
			System.out.println(findPerson.get());
			return findPerson.get();
		}else {
			return null;
		}
	}
}
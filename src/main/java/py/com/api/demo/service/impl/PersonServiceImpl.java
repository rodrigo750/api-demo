package py.com.api.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.api.demo.entities.Person;
import py.com.api.demo.exceptions.PersonException;
import py.com.api.demo.repositories.PersonRepository;
import py.com.api.demo.service.PersonService;

/*
 * Created by Rodrigo
 */

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonRepository personRepository;
	
	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public Person getById(long id) throws PersonException{
		Person p = personRepository.findById(id);
		if (p == null) throw new PersonException("Person not found");
		return p;
	}

	@Override
	public void createPerson(Person person) throws PersonException{
		Person p = checkPerson(person.getId());
		if(p!=null) {
			throw new PersonException("Person Already exist");
		}else {
			personRepository.save(person);
		}
	}

	@Override
	public void deletePerson(long id) throws PersonException{
		getById(id);
		personRepository.deleteById(id);
	}

	@Override
	public void updatePerson(Person person, long id) throws PersonException{
		Person p = getById(id);
		if(p!=null) personRepository.save(person);
	}
	
	public Person checkPerson(long id) {
		return personRepository.findById(id);
	}
	
}

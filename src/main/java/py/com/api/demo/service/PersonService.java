package py.com.api.demo.service;

import java.util.List;

import py.com.api.demo.entities.Person;
import py.com.api.demo.exceptions.PersonException;

/*
 * Created by Rodrigo
 */

public interface PersonService {
	List<Person> getAll();
	Person getById(long id) throws PersonException;
	void createPerson(Person person) throws PersonException;
	void deletePerson(long id) throws PersonException;
	void updatePerson(Person person, long id) throws PersonException;
}

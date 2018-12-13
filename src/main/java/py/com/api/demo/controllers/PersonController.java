package py.com.api.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.com.api.demo.entities.Person;
import py.com.api.demo.exceptions.PersonException;
import py.com.api.demo.service.PersonService;

/*
 * Created by Rodrigo
 */

@RestController
@Api(value="person", description="Operations pertaining to persons")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping("/")
	public String greeting() {
		return "GG IZI";
	}
	
	@ApiOperation(value = "View a list of persons", response = Iterable.class, position = 1)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 404, message = "No persons found")
	})
	@RequestMapping(value="/api/persons",method=RequestMethod.GET)
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@ApiOperation(value = "Filter person by id", response = Iterable.class, position = 2)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved person"),
	        @ApiResponse(code = 404, message = "No person found")
	})
	@RequestMapping(value="/api/person/{personId}",method=RequestMethod.GET)
	public Person getPerson(@PathVariable(name="personId")int id) throws PersonException{
		return personService.getById(id);
	}
	
	
	@ApiOperation(value = "Create person", response = Iterable.class, position = 3)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Person created"),
	        @ApiResponse(code = 409, message = "Error while creating person")
	})
	@RequestMapping(value="/api/person", method=RequestMethod.POST)
	public void savePerson(@RequestBody Person person) throws PersonException{
		personService.createPerson(person);
	}
	
	@ApiOperation(value = "Delete person", response = Iterable.class, position = 4)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Person deleted"),
	        @ApiResponse(code = 409, message = "Error while deleting person")
	})
	@RequestMapping(value="/api/person/{personId}", method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable(name="personId")long id) throws PersonException{
		personService.deletePerson(id);
	}
	
	@ApiOperation(value = "Update person", response = Iterable.class, position = 5)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Person updated"),
	        @ApiResponse(code = 409, message = "Error while updating person")
	})
	@RequestMapping(value="/api/person/{personId}", method=RequestMethod.PUT)
	public void updatePerson(@RequestBody Person person, @PathVariable(name="personId")long id) throws PersonException{
		personService.updatePerson(person,id);
	}

}

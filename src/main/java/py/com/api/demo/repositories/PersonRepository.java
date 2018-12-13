package py.com.api.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import py.com.api.demo.entities.Person;

/*
 * Created by Rodrigo
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	List<Person> findAll();
	Person findById(long id);
}

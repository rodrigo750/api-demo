package py.com.api.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Created by Rodrigo
 */

@Entity
public class Person {
	
	@Id
	private Long id;
	private String name;
	private String last_name;
	private Integer age;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}

package de.lette.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("person")
@SessionScoped
public class Person implements Serializable{

    private List<Person> list;
    private String forename;
    private String surname;
    private int age;
    
	public Person() {
		list = new ArrayList<>();
	}
	/**
	 * @return the forename
	 */
	public String getForename() {
		return forename;
	}
	/**
	 * @param forename the forename to set
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
    /**
	 * @return the list
	 */
	public List<Person> getList() {
		return list;
	}
	
	public void submit()
    {
		Person p = new Person();
		p.setAge(age);
		p.setForename(forename);
		p.setSurname(surname);
		list.add(p);
    }
    
}

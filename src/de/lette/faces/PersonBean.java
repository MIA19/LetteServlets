package de.lette.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("personBean")
@SessionScoped
public class PersonBean implements Serializable{

    private List<PersonBean> list;
    private String forename;
    private String surname;
    private int age;
    
	public PersonBean() {
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
	public List<PersonBean> getList() {
		return list;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public void submit()
    {
		PersonBean p = new PersonBean();
		p.setAge(age);
		p.setForename(forename);
		p.setSurname(surname);
		list.add(p);
    }
    
}

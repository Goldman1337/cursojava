package com.comics.app.Model;

public class Person {
	
	private int idPerson;
	private String namePerson;
	private String telephonePerson;

	
	/*
	 * Getters and Setters
	 */
	public int getIdPerson() {
		return idPerson;
	}
	
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public String getNamePerson() {
		return namePerson;
	}
	
	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}
	
	public String getTelephonePerson() {
		return telephonePerson;
	}
	
	public void setTelephonePerson(String telephonePerson) {
		this.telephonePerson = telephonePerson;
	}
	
	
	/*
	 * Builders
	 */
	public Person () {
		
	}
	
	public Person(String name, String telephone) {
		this.namePerson = name;
		this.telephonePerson = telephone;
	}
}

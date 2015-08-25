package com.comics.app.Model;

public class Loan {
	
	private int idLoan;
	private Comic comic;
	private Person person;
	private String date;
	
	
	/*
	 * Getters and Setters
	 */
	public int getIdLoan() {
		return idLoan;
	}
	
	public void setIdLoan(int idLoan) {
		this.idLoan = idLoan;
	}
	
	public Comic getComic() {
		return comic;
	}
	
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	/*
	 * Builders
	 */
	public Loan() {
		
	}
	
	public Loan(Comic comic, Person person, String date) {
		this.comic = comic;
		this.person = person;
		this.date = date;
	}
}

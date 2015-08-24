package com.comics.app.Model;

public class Comic {
	
	int idComic;
	int quantityComic;
	String nameComic;
	String companyComic;
	String reviewComic;
	
	
	/*
	 * Getters and Setters.
	 */
	public int getIdComic() {
		return idComic;
	}
	
	public void setIdComic(int idComic) {
		this.idComic = idComic;
	}
	
	public String getNameComic() {
		return nameComic;
	}
	
	public void setNameComic(String nameComic) {
		this.nameComic = nameComic;
	}
	
	public String getCompanyComic() {
		return companyComic;
	}
	
	public void setCompanyComic(String companyComic) {
		this.companyComic = companyComic;
	}
	
	public String getReviewComic() {
		return reviewComic;
	}
	
	public void setReviewComic(String reviewComic) {
		this.reviewComic = reviewComic;
	}
	
	public int getQuantityComic() {
		return quantityComic;
	}

	public void setQuantityComic(int quantityComic) {
		this.quantityComic = quantityComic;
	}

	
	/*
	 * Builders.
	 */
	public Comic () {
		
	}
	
	public Comic (String name, String company, String review, int quantity) {
		this.nameComic = name;
		this.companyComic = company;
		this.reviewComic = review;
		this.quantityComic = quantity;
	}
}
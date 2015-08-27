package com.comics.app.Model;

public class Role {
	
	int idRole;
	String Name;
	boolean ComicAdd;
	boolean ComicEdit;
	boolean ComicDelete;
	boolean PersonAdd;
	boolean PersonEdit;
	boolean PersonDelete;
	boolean LoanAdd;
	boolean LoanEdit;
	boolean LoanDelete;
	
	
	/*
	 * Getters and Setters.
	 */
	public int getIdRole() {
		return idRole;
	}
	
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return Name;
	}
	
	public void setNameRole(String idRole) {
		this.Name = Name;
	}
	
	public boolean getComicAdd() {
		return ComicAdd;
	}
	
	public void setComicAdd(boolean ComicAdd) {
		this.ComicAdd = ComicAdd;
	}
	
	public boolean getComicEdit() {
		return ComicEdit;
	}
	
	public void setComicEdit(boolean ComicEdit) {
		this.ComicEdit = ComicEdit;
	}
	
	public boolean getComicDelete() {
		return ComicDelete;
	}
	
	public void setComicDelete(boolean ComicDelete) {
		this.ComicDelete = ComicDelete;
	}
	
	public boolean getPersonAdd() {
		return PersonAdd;
	}
	
	public void setPersonAdd(boolean PersonAdd) {
		this.PersonAdd = PersonAdd;
	}
	
	public boolean getPersonEdit() {
		return PersonEdit;
	}
	
	public void setPersonEdit(boolean PersonEdit) {
		this.PersonEdit = PersonEdit;
	}
	
	public boolean getPersonDelete() {
		return PersonDelete;
	}
	
	public void setPersonDelete(boolean PersonDelete) {
		this.PersonDelete = PersonDelete;
	}
	
	public boolean getLoanAdd() {
		return PersonAdd;
	}
	
	public void setLoanAdd(boolean LoanAdd) {
		this.LoanAdd = LoanAdd;
	}
	
	public boolean getLoanEdit() {
		return LoanEdit;
	}
	
	public void setLoanEdit(boolean LoanEdit) {
		this.LoanEdit = LoanEdit;
	}
	
	public boolean getLoanDelete() {
		return LoanDelete;
	}
	
	public void setLoanDelete(boolean LoanDelete) {
		this.LoanDelete = LoanDelete;
	}

	
	/*
	 * Builders.
	 */
	public Role () {
		
	}
	
	public Role (String name, boolean ComicAdd, boolean ComicEdit, boolean ComicDelete,
			boolean PersonAdd, boolean PersonEdit, boolean PersonDelete, boolean LoanAdd, 
			boolean LoanEdit,boolean LoanDelete) {
this.Name=name;
this.ComicAdd=ComicAdd;
this.ComicEdit=ComicEdit;
this.ComicDelete=ComicDelete;
this.PersonAdd=PersonAdd;
this.PersonEdit=PersonEdit;
this.PersonDelete=PersonDelete;
this.LoanAdd=LoanAdd;
this.LoanEdit=LoanEdit;
this.LoanDelete=LoanDelete;
	}
}
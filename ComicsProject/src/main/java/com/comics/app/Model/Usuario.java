package com.comics.app.Model;

public class Usuario {
	
	private int idUser;
	private String UserName;
	private String Password;
	private Role role;
	
	
	/*
	 * Getters and Setters
	 */
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idLoan) {
		this.idUser = idLoan;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role Role) {
		this.role = Role;
	}
	
	
	/*
	 * Builders
	 */
	public Usuario() {
		
	}
	
	public Usuario(String UserName, String Password, Role role) {
		this.UserName = UserName;
		this.Password = Password;
		this.role = role;
	}
}

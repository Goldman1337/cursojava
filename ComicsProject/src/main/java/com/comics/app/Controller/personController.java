package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Model.Person;
import com.comics.app.Dao.personDao;

public class personController {
	
	personDao persondao = new personDao();
	
	public boolean login(String username, String password) {
		if (username.equals("Sheldon") && password.equals("Bazzinga")) {
			return true;
		}
		return false;
	}
	
	public boolean add(Person c) {
		boolean rta = persondao.add(c);
		return rta;
	}
	
	public Person get(int key) {
		Person p = persondao.get(key);		
		return p;
	}
	
	public List<Person> getAll() {
		List<Person> list = persondao.getAll();
		return list;
	}
	
	public boolean delete(int key) {
		boolean rta = persondao.delete(key);		
		return rta;
	}
	
	public boolean update(Person p) {
		boolean rta = persondao.update(p);
		return rta;
	}
}
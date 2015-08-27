package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Dao.RoleDao;
import com.comics.app.Model.Role;

public class RoleController {
	
	RoleDao roledao = new RoleDao();
	
	public boolean addRole (Role r) {
		boolean rta = roledao.add(r);
		
		return rta;
	}
	
	public List<Role> getAll() {
		List<Role> list = roledao.getAll();
		return list;
	}
	
	public boolean delete(int key) {
		boolean rta = roledao.delete(key);		
		return rta;
	}
	
	public Role get (int key) {
		Role l = new Role();
		l = roledao.get(key);
		return l;
	}
	
	public boolean update(Role l) {
		boolean rta = roledao.update(l);
		return rta;
	}
}

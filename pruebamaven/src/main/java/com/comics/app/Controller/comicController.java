package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Dao.comicDao;
import com.comics.app.Model.Comic;

public class comicController {
	
	comicDao comicdao = new comicDao();
	
	public boolean add(Comic c) {
		boolean rta = comicdao.add(c);
		return rta;
	}
	
	public Comic get(int key) {
		Comic c = comicdao.get(key);		
		return c;
	}
	
	public List<Comic> getAll() {
		List<Comic> list = comicdao.getAll();
		return list;
	}
	
	public boolean delete(int key) {
		boolean rta = comicdao.delete(key);		
		return rta;
	}
	
	public boolean update(Comic c) {
		boolean rta = comicdao.update(c);
		return rta;
	}
}
package com.comics.app.Dao;

import java.util.List;

public interface genericDao <C> {
	
	public boolean add(C c);
	public boolean update(C c);
	public boolean delete(Object key);
	public C get(Object key);
	public List<C> getAll();
	
}
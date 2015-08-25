package com.comics.app.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.comics.app.Model.Person;

public class personDao implements genericDao<Person> {
	
	// SQL CRUD Statements.
	private final String SQL_INSERT = "INSERT INTO persons (namePerson, telephonePerson) VALUES (?, ?)";
	private final String SQL_DELETE = "DELETE FROM persons WHERE idPerson = ?";
	private final String SQL_GET_ALL = "SELECT * FROM persons";
	private final String SQL_GET = "SELECT * FROM persons WHERE ( idPerson = ?)";
	
	private final connectionDB conn = connectionDB.getConnection();
	
	public boolean add(Person c) {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getNamePerson());
			ps.setString(2, c.getTelephonePerson());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	public boolean update(Person c) {
		// Not Implemented.
		return false;
	}

	public boolean delete(Object key) {
		PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_DELETE);
			ps.setInt(1, (Integer)key);
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	public Person get(Object key) {
		Person p = new Person();
		
		try {
			
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET);
			ps.setInt(1, (Integer)key);
			
			res = ps.executeQuery();
			while(res.next()) {
				p.setIdPerson(res.getInt("idPerson"));
				p.setNamePerson(res.getString("namePerson"));
				p.setTelephonePerson(res.getString("telephonePerson"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return p;
	}

	public List<Person> getAll() {
		List<Person> list = new ArrayList<Person>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				
				Person c = new Person();
				c.setIdPerson(res.getInt("idPerson"));
				c.setNamePerson(res.getString("namePerson"));
				c.setTelephonePerson(res.getString("telephonePerson"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return list;
	}
	
}
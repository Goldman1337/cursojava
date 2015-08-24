package com.comics.app.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.comics.app.Model.Comic;
import com.comics.app.Model.Loan;
import com.comics.app.Model.Person;

public class loanDao implements genericDao<Loan> {

	private final String SQL_INSERT = "INSERT INTO loans (Persons_idPerson, Comics_idComic, date) VALUES (?, ?, ?)";
	private final String SQL_GET_ALL = "select idLoan, c.nameComic, p.namePerson, l.date from  loans l join comics c on l.Comics_idComic = c.idComic join persons p on l.Persons_idPerson = p.idPerson ";
	private final String SQL_DELETE = "DELETE FROM loans WHERE idLoan = ?";
	private final String SQL_GET = "SELECT * FROM loans WHERE ( idLoan = ?)";
	
	private final connectionDB conn = connectionDB.getConnection();
	
	public boolean add(Loan c) {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setInt(1, c.getPerson().getIdPerson());
			ps.setInt(2, c.getComic().getIdComic());
			ps.setString(3, c.getDate());

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

	public boolean update(Loan c) {
		// TODO Auto-generated method stub
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

	public Loan get(Object key) {
		Loan l = new Loan();
		
		try {
			
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET);
			ps.setInt(1, (Integer)key);
			
			res = ps.executeQuery();
			while(res.next()) {
				l.setIdLoan(res.getInt("idLoan"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return l;
	}

	public List<Loan> getAll() {
		List<Loan> list = new ArrayList<Loan>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			Comic c = new Comic();
			Person p = new Person();
			
			while(res.next()) {
				
				Loan l = new Loan();
				l.setIdLoan(res.getInt("idLoan"));
				
				l.setComic(c);
				c.setNameComic(res.getString("nameComic"));
				
				l.setPerson(p);
				p.setNamePerson(res.getString("namePerson"));

				l.setDate(res.getString("date"));
				
				list.add(l);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return list;
	}

}
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
	private final String SQL_UPDATE = "UPDATE loans SET Persons_idPerson = ?, Comics_idComic = ?, date = ? WHERE idLoan = ? ";
	private final String SQL_GET_ALL = "SELECT idLoan,c.nameComic,date, Persons_idPerson,c.companyComic,"
			+ "c.reviewComic,c.quantityComic,Comics_idComic ,p.namePerson,p.telephonePerson "
			+ "FROM comics.loans inner join comics.comics as c on c.idComic=loans.Comics_idComic "
			+ "inner join comics.persons as p on p.idPerson = loans.Persons_idPerson";
	private final String SQL_DELETE = "DELETE FROM loans WHERE idLoan = ?";
	private final String SQL_GET = "SELECT idLoan,c.nameComic,date, Persons_idPerson,c.companyComic,"
			+ "c.reviewComic,c.quantityComic,Comics_idComic ,p.namePerson,p.telephonePerson "
			+ "FROM comics.loans inner join comics.comics as c on c.idComic=loans.Comics_idComic "
			+ "inner join comics.persons as p on p.idPerson = loans.Persons_idPerson WHERE ( idLoan = ?)";
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
PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			ps.setInt(1, c.getPerson().getIdPerson());
			ps.setInt(2, c.getComic().getIdComic());
			ps.setString(3, c.getDate());
			ps.setInt(4, c.getIdLoan());
			
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
	 	 
	 	Comic c = new Comic();
	 	Person p = new Person();
	 	l.setIdLoan(res.getInt("idLoan"));
	 	l.setDate(res.getString("date"));
	 	c.setNameComic(res.getString("c.nameComic"));
	 	c.setIdComic(res.getInt("Comics_idComic"));
	 	c.setQuantityComic(res.getInt("c.quantityComic"));
	 	c.setReviewComic(res.getString("c.reviewComic"));
	 	l.setComic(c);
	 	p.setNamePerson(res.getString("p.namePerson"));
	 	p.setIdPerson(res.getInt("Persons_idPerson"));
	 	p.setTelephonePerson(res.getString("p.telephonePerson"));
	 	l.setPerson(p);
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
			
			while(res.next()) {
				Loan l = new Loan();
				Comic c = new Comic();
				Person p = new Person();
				
				l.setIdLoan(res.getInt("idLoan"));
				l.setDate(res.getString("date"));
				c.setNameComic(res.getString("c.nameComic"));
				c.setIdComic(res.getInt("Comics_idComic"));
				c.setQuantityComic(res.getInt("c.quantityComic"));
				c.setReviewComic(res.getString("c.reviewComic"));
				l.setComic(c);
				p.setNamePerson(res.getString("p.namePerson"));
				p.setIdPerson(res.getInt("Persons_idPerson"));
				p.setTelephonePerson(res.getString("p.telephonePerson"));
				l.setPerson(p);
				
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
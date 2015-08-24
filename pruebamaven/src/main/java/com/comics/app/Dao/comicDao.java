package com.comics.app.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.comics.app.Model.Comic;

public class comicDao implements genericDao<Comic> {
	
	// SQL CRUD Statements.
	private final String SQL_INSERT = "INSERT INTO comics (nameComic, companyComic, reviewComic, quantityComic) VALUES (?, ?, ?, ?)";
	private final String SQL_DELETE = "DELETE FROM comics WHERE idComic = ?";
	private final String SQL_UPDATE = "UPDATE comics SET nameComic = ?, companyComic = ?, reviewComic = ?, quantityComic = ? WHERE idComic = ? ";
	private final String SQL_GET_ALL = "SELECT * FROM comics";
	private final String SQL_GET = "SELECT * FROM comics WHERE ( idComic = ?)";
	
	private final connectionDB conn = connectionDB.getConnection();
	
	public boolean add(Comic c) {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getNameComic());
			ps.setString(2, c.getCompanyComic());
			ps.setString(3, c.getReviewComic());
			ps.setInt(4, c.getQuantityComic());
			
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

	public boolean update(Comic c) {
		PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			ps.setString(1, c.getNameComic());
			ps.setString(2, c.getCompanyComic());
			ps.setString(3, c.getReviewComic());
			ps.setInt(4, c.getQuantityComic());
			ps.setInt(5, c.getIdComic());
			
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

	public Comic get(Object key) {		
		Comic c = new Comic();
		
		try {
			
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET);
			ps.setInt(1, (Integer)key);
			
			res = ps.executeQuery();
			while(res.next()) {
				c.setIdComic(res.getInt("idComic"));
				c.setNameComic(res.getString("nameComic"));
				c.setCompanyComic(res.getString("companyComic"));
				c.setReviewComic(res.getString("reviewComic"));
				c.setQuantityComic(res.getInt("quantityComic"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return c;
	}

	public List<Comic> getAll() {
		List<Comic> list = new ArrayList<Comic>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				
				Comic c = new Comic();
				c.setIdComic(res.getInt("idComic"));
				c.setNameComic(res.getString("nameComic"));
				c.setCompanyComic(res.getString("companyComic"));
				c.setReviewComic(res.getString("reviewComic"));
				c.setQuantityComic(res.getInt("quantityComic"));
				
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
package com.comics.app.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.comics.app.Model.Role;

public class RoleDao implements genericDao<Role> {
	
	// SQL CRUD Statements.
	private final String SQL_INSERT = "INSERT INTO roles (Name, ComicAdd,ComicEdit,"
			+ "ComicDelete,PersonAdd,PersonEdit,PersonDelete,LoanAdd,LoanEdit,"
			+ "LoanDelete) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_DELETE = "DELETE FROM roles WHERE idroles = ?";
	private final String SQL_UPDATE = "UPDATE roles SET Name = ?, ComicAdd = ?, ComicEdit = ?, ComicDelete = ?,"
			+ "PersonAdd=?,PersonEdit=?,PersonDelete=?,LoanAdd=?,LoanEdit=?,"
			+ "LoanDelete=? WHERE idroles = ? ";
	private final String SQL_GET_ALL = "SELECT * FROM roles";
	private final String SQL_GET = "SELECT * FROM roles WHERE ( idroles = ?)";
	
	private final connectionDB conn = connectionDB.getConnection();
	
	public boolean add(Role c) {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getNameRole());
			ps.setBoolean(2, c.getComicAdd());
			ps.setBoolean(3, c.getComicEdit());
			ps.setBoolean(4, c.getComicDelete());
			ps.setBoolean(5, c.getPersonAdd());
			ps.setBoolean(6, c.getPersonEdit());
			ps.setBoolean(7, c.getPersonDelete());
			ps.setBoolean(8, c.getLoanAdd());
			ps.setBoolean(9, c.getLoanEdit());
			ps.setBoolean(10, c.getLoanDelete());
			
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

	public boolean update(Role c) {
		PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			ps.setString(1, c.getNameRole());
			ps.setBoolean(2, c.getComicAdd());
			ps.setBoolean(3, c.getComicEdit());
			ps.setBoolean(4, c.getComicDelete());
			ps.setBoolean(5, c.getPersonAdd());
			ps.setBoolean(6, c.getPersonEdit());
			ps.setBoolean(7, c.getPersonDelete());
			ps.setBoolean(8, c.getLoanAdd());
			ps.setBoolean(9, c.getLoanEdit());
			ps.setBoolean(10, c.getLoanDelete());
			ps.setInt(11, c.getIdRole());
			
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

	public Role get(Object key) {		
		Role c = new Role();
		
		try {
			
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET);
			ps.setInt(1, (Integer)key);
			
			res = ps.executeQuery();
			while(res.next()) {
				c.setIdRole(res.getInt("idroles"));
				c.setNameRole(res.getString("Name"));
				c.setComicAdd(res.getBoolean("ComicAdd"));
				c.setComicEdit(res.getBoolean("ComicEdit"));
				c.setComicDelete(res.getBoolean("ComicDelete"));
				c.setPersonAdd(res.getBoolean("PersonAdd"));
				c.setPersonEdit(res.getBoolean("PersonEdit"));
				c.setPersonDelete(res.getBoolean("PersonDelete"));
				c.setLoanAdd(res.getBoolean("LoanAdd"));
				c.setLoanEdit(res.getBoolean("LoanEdit"));
				c.setLoanDelete(res.getBoolean("LoanDelete"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return c;
	}

	public List<Role> getAll() {
		List<Role> list = new ArrayList<Role>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				
				Role c = new Role();
				c.setIdRole(res.getInt("idroles"));
				c.setNameRole(res.getString("Name"));
				c.setComicAdd(res.getBoolean("ComicAdd"));
				c.setComicEdit(res.getBoolean("ComicEdit"));
				c.setComicDelete(res.getBoolean("ComicDelete"));
				c.setPersonAdd(res.getBoolean("PersonAdd"));
				c.setPersonEdit(res.getBoolean("PersonEdit"));
				c.setPersonDelete(res.getBoolean("PersonDelete"));
				c.setLoanAdd(res.getBoolean("LoanAdd"));
				c.setLoanEdit(res.getBoolean("LoanEdit"));
				c.setLoanDelete(res.getBoolean("LoanDelete"));
				
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
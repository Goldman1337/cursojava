package com.comics.app.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.comics.app.Model.Role;
import com.comics.app.Model.Usuario;

public class UsuarioDao implements genericDao<Usuario> {
	
	// SQL CRUD Statements.
	private final String SQL_INSERT = "INSERT INTO users (UserName, Password,Roleid) VALUES (?, ?,?)";
	private final String SQL_UPDATE = "UPDATE users SET UserName = ?, Password = ? Roleid=? WHERE idUsers = ? ";
	private final String SQL_DELETE = "DELETE FROM users WHERE idUsers = ?";
	private final String SQL_GET_ALL = "SELECT * FROM users";
	private final String SQL_GET = "SELECT * FROM users WHERE ( idUsers = ?)";
	
	private final connectionDB conn = connectionDB.getConnection();
	
	public boolean add(Usuario c) {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getUserName());
			ps.setString(2, c.getPassword());
			ps.setInt(3, c.getRole().getIdRole());
			
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

	public boolean update(Usuario c) {
		PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);

			ps.setString(1, c.getUserName());
			ps.setString(2, c.getPassword());
			ps.setInt(3, c.getRole().getIdRole());
			ps.setInt(4, c.getIdUser());
			
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

	public Usuario get(Object key) {
		Usuario p = new Usuario();
		
		try {
			
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET);
			ps.setInt(1, (Integer)key);
			
			res = ps.executeQuery();
			while(res.next()) {
				Role r = new Role();
				p.setIdUser(res.getInt("idUser"));
				p.setUserName(res.getString("UserName"));
				p.setPassword(res.getString("Password"));
				r.setIdRole(res.getInt("idRole"));
				r.setNameRole(res.getString("Name"));
				r.setComicAdd(res.getBoolean("ComicAdd"));
				r.setComicEdit(res.getBoolean("ComicEdit"));
				r.setComicDelete(res.getBoolean("ComicDelete"));
				r.setPersonAdd(res.getBoolean("PersonAdd"));
				r.setPersonEdit(res.getBoolean("PersonEdit"));
				r.setPersonDelete(res.getBoolean("PersonDelete"));
				r.setLoanAdd(res.getBoolean("LoanAdd"));
				r.setLoanEdit(res.getBoolean("LoanEdit"));
				r.setLoanDelete(res.getBoolean("LoanDelete"));
				p.setRole(r);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return p;
	}

	public List<Usuario> getAll() {
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				Usuario p = new Usuario();
				Role r = new Role();
				p.setIdUser(res.getInt("idUser"));
				p.setUserName(res.getString("UserName"));
				p.setPassword(res.getString("Password"));
				r.setIdRole(res.getInt("idRole"));
				r.setNameRole(res.getString("Name"));
				r.setComicAdd(res.getBoolean("ComicAdd"));
				r.setComicEdit(res.getBoolean("ComicEdit"));
				r.setComicDelete(res.getBoolean("ComicDelete"));
				r.setPersonAdd(res.getBoolean("PersonAdd"));
				r.setPersonEdit(res.getBoolean("PersonEdit"));
				r.setPersonDelete(res.getBoolean("PersonDelete"));
				r.setLoanAdd(res.getBoolean("LoanAdd"));
				r.setLoanEdit(res.getBoolean("LoanEdit"));
				r.setLoanDelete(res.getBoolean("LoanDelete"));
				p.setRole(r);
				
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return list;
	}
	
}
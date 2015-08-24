package com.comics.app.Dao;

import java.sql.*;

public class connectionDB {
	
	private static connectionDB instanceDb;
	private Connection conn;
	
	private connectionDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/comics", "root", "root");	
	}
	
	public synchronized static connectionDB getConnection() {
		try {	
			if(instanceDb == null) {
				instanceDb = new connectionDB();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instanceDb;
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public void closeConnection() {
		instanceDb = null;
	}	
}
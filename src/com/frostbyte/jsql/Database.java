package com.frostbyte.jsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Account account;
	private String database;
	
	public Database(Account account, String database){
		this.account = account;
		this.database = database;
	}
	
	public Database(String host, String username, String password, String database){
		this.account = new Account(host, username, password);
		this.database = database;
	}
	
	public void executeQuery(String query){
		Connection connection = null;
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (Exception exception) {
			exception.printStackTrace();

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	protected Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String conn = "jdbc:mysql://" + account.getHost().getHost() + "/" + database;
			return DriverManager.getConnection(conn, account.getUsername(), account.getPassword());
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;

	}
	
	public void drop(){
		executeQuery("DROP DATABASE " + database);
	}
}

package com.frostbyte.javasqlapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlHandler {
	public static boolean log = false, log_errors = false, console_errors = true;
	public static String SQL_HOST, SQL_USER, SQL_PASS;

	public static void log(String message) {
		if (log) {
			System.out.println("Java SQL API << Log >> " + message);
		}
	}

	public static void error(String message) {
		if (console_errors) {
			System.out.println("Java SQL API << Error >> " + message);
		}
	}

	public static void executeQuery(String SQL_DATA, String query) {
		if(!checkVariables(SQL_DATA)){
			return;
		}
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String conn = "jdbc:mysql://" + SQL_HOST + "/" + SQL_DATA;
			connection = DriverManager.getConnection(conn, SQL_USER, SQL_PASS);
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

	public static Connection getConnection(String SQL_DATA) {
		if(!checkVariables(SQL_DATA)){
			return null;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String conn = "jdbc:mysql://" + SQL_HOST + "/" + SQL_DATA;
			return DriverManager.getConnection(conn, SQL_USER, SQL_PASS);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}
	
	/**
	 * A method that checks if all the variables needed 
	 * to establish a connection are set.
	 * 
	 * @return	If all the variables are all set
	 */
	public static boolean checkVariables(String SQL_DATA){
		List<String> unknownVariables = new ArrayList<String>();
		if(SQL_HOST == null){
			unknownVariables.add("SQL_HOST");
		}
		
		if(SQL_USER == null){
			unknownVariables.add("SQL_USER");
		}
		
		if(SQL_PASS == null){
			unknownVariables.add("SQL_PASS");
		}
		
		if(SQL_DATA == null){
			unknownVariables.add("SQL_DATA");
		}
		
		if(!unknownVariables.isEmpty()){
			Logger.log(Logger.SQL_FATAL_ERROR, "All connection variables not found. Unknown variables: " + unknownVariables.toString());
		}
		
		return unknownVariables.isEmpty();
	}

}

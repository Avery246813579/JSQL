package com.frostbyte.javasqlapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlHandler {
	public static boolean log = true, log_errors = false, console_errors = true;
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
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String conn = "jdbc:mysql://" + SQL_HOST + "/" + SQL_DATA;
			return DriverManager.getConnection(conn, SQL_USER, SQL_PASS);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

}

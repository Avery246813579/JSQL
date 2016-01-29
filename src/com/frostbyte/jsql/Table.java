package com.frostbyte.jsql;

public class Table {
	
	private Database database;
	private String table;
	
	public Table(Database database, String table){
		this.database = database;
		this.table = table;
	}
	
	public Table(Account account, String database, String table){
		this.database = new Database(account, database);
		this.table = table;
	}
	
	public Table(String username, String password, String database, String table){
		this.database = new Database(username, password, database);
		this.table = table;
	}
}

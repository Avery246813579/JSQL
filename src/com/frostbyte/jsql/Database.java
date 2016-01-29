package com.frostbyte.jsql;

public class Database {
	private Account account;
	private String database;
	
	public Database(Account account, String database){
		this.account = account;
		this.database = database;
	}
	
	public Database(String username, String password, String database){
		this.account = new Account(username, password);
		this.database = database;
	}

}

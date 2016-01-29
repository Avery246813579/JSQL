package com.frostbyte.jsql;

public final class Account {
	private String username, password;

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
		return username;
	}
}

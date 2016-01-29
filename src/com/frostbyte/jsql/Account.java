package com.frostbyte.jsql;

public final class Account {
	private Host host;
	private String username, password;

	public Account(Host host, String username, String password) {
		this.host = host;
		this.username = username;
		this.password = password;
	}
	
	public Account(String host, String username, String password){
		this.host = new Host(host);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public Host getHost(){
		return host;
	}
}

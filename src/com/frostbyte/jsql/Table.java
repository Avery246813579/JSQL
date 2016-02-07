package com.frostbyte.jsql;

import java.util.ArrayList;
import java.util.List;

public class Table {
	protected List<Property> properties = new ArrayList<Property>();
	private Database database;
	private String name;
	
	public Table(Database database, String name){
		this.database = database;
		this.name = name;
	}
	
	public Table(Account account, String database, String name){
		this.database = new Database(account, database);
		this.name = name;
	}
	
	public Table(String host, String username, String password, String database, String name){
		this.database = new Database(host, username, password, database);
		this.name = name;
	}
	
	public void create(){
		String props = "";
		
		for(Property property : properties){
			props += ", " + property;
		}
		
		
		database.executeQuery("CREATE TABLE " + name + "(" + props.substring(2) + ")");
	}
	
	public void drop(){
		database.executeQuery("DROP TABLE " + name);
	}
	
	public void truncate(){
		database.executeQuery("TRUNCATE TABLE " + name);
	}
	
	public void addRow(){
		
	}
}

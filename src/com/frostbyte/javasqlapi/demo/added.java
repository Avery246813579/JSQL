package com.frostbyte.javasqlapi.demo;

import com.frostbyte.javasqlapi.Table;

public class added extends Table{
	public added() {
		super("riotapi_static", "Itemz");
		addPrimaryKey("id");
		
		variables.put("id", "INT NOT NULL AUTO_INCREMENT");
		variables.put("name", "VARCHAR(30)");
		variables.put("description", "VARCHAR(30)");
	}
}

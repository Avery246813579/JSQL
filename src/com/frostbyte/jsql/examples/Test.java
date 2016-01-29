package com.frostbyte.jsql.examples;

import com.frostbyte.jsql.Account;
import com.frostbyte.jsql.Database;
import com.frostbyte.jsql.Host;
import com.frostbyte.jsql.Property;
import com.frostbyte.jsql.Property.Type;
import com.frostbyte.jsql.Table;

public class Test extends Table{

	public Test() {
		super(new Database(new Account(new Host("127.0.0.1"), "root", ""), "test"), "Test");

		properties.add(new Property("id", Type.INT));
		
		create();
	}

	public static void main(String[] args){
		new Test();
	}
}

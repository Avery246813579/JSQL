package com.frostbyte.javasqlapi.demo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.frostbyte.javasqlapi.SqlHandler;

public class Handler extends SqlHandler{
	added added = new added();
	
	public static void main(String[] args){
		new Handler();
		
	}
	
	public Handler() {
		SQL_HOST = "localhost";
		SQL_PASS = "";
		SQL_USER = "root";
		
		Map<String, Object> insert = new LinkedHashMap<String, Object>();
		insert.put("name", "Kittens are hot");
		added.update(insert, "description", "I don't love");

		List<Map<String, Object>> values = added.get();
		for(Map<String, Object> value : values){
			System.out.println("Name: "+ value.get("name") + "           Description" + value.get("description"));
		}
	}
}

package com.frostbyte.javasqlapi.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
		
		Map<String, Object> where = new LinkedHashMap<String, Object>();
		where.put("name", "Kitten Love");
		where.put("id", 8);
		Map<String, Object> put = new HashMap<String, Object>();
		put.put("description", "Hail");
		added.update(put, where);
	}
}

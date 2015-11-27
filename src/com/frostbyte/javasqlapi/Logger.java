package com.frostbyte.javasqlapi;

public class Logger {
	public static final String SQL_FATAL_ERROR = "SQL FATAL ERROR", SQL_WARNING = "SQL WARNING", SQL_STATUS = "SQL STATUS";
	
	public static void log(String message){
		System.out.println(message);
	}
	
	public static void log(String prefix, String message){
		System.out.println(prefix + " >> " + message);
	}
	
	public static void log(String message, Exception ex){
		System.out.println("\nA error has occurred! Printing Result {" + "\n\tException: " + ex.getClass().getName()
				+ "\n\tDescription: " + message + "\n\tReason: " + ex.getLocalizedMessage());

		if (SqlHandler.log_errors) {
			System.out.println("\tStack: ");
			ex.printStackTrace();
		}

		System.out.println("\n}\n");
	}
}

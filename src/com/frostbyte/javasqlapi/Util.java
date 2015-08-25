package com.frostbyte.javasqlapi;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Util {
	public static PreparedStatement setPreparedStatement(String type, String value, int preparedLocation, PreparedStatement preparedStatement) throws SQLException {
		switch (type.toLowerCase()) {
			case "Varchar":
				preparedStatement.setString(preparedLocation, value);
				break;
		}
		
		return preparedStatement;
	}
}

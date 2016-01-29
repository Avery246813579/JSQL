package com.frostbyte.jsql;

public class Property {
	private String name, _default;
	private Type type;
	private int length;
	private Collation collation;
	private Attributes attributes;
	private Index index;
	private boolean auto_incrementing, _null;
	

	public Property(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public String toString(){
		String query = name + " " + type;
		
		if(length != 0){
			query += "(" + length + ")";
		}
		
		if(!_null){
			query += " NOT NULL";
		}
		
		return query;
	}
	
	public enum Type {	
		/** Numeric **/
		TINYINT,
		SMALLINT,
		MEDIUMINT,
		INT,
		BIGINT,
		DECIMAL,
		FLOAT,
		DOUBLE,
		REAL,	
		BIT,
		BOOLEAN,
		SERIAL,
		
		/** Data and Time **/
		DATE,
		DATETIME,
		TIMESTAMP,
		TIME,
		YEAR,
		
		/** String **/
		CHAR,
		VARCHAR,
		TINYTEXT,
		TEXT,
		MEDIUMTEXT,
		LONGTEXT,
		BINARY,
		VARBINARY,
		TINYBLOB,
		MEDIUMBLOB,
		BLOB,
		LONGBLOB,
		ENUM,
		SET,

		/** Spatial **/
		GEOMETRY,
		POINT,
		LINESTRING,
		POLYGON,
		MULTIPOINT,
		MULTILINESTRING,
		MULTIPOLYGON,
		GEOMETRYCOLLECTION;	
	}

	public enum Collation{
		/** armscii8 **/
		armscii8_bin,
		armscii8_general_ci,
		
		/** ascii **/
		ascii_bin,
		ascii_general_ci,
		
		/** big5 **/
		big5_bin,
		big5_chinese_ci,
		
		/** binary **/
		binary,
		
		/** cp1250 **/
		cp1250_bin,
		cp1250_croatian_ci,
		cp1250_czech_cs,
		cp1250_general_ci,
		cp1250_polish_ci,
		
		/** cp1251 **/
		cp1251_bin,
		cp1251_bulgarian_ci,
		cp1251_general_ci,
		cp1251_general_cs,
		cp1251_ukrainian_ci,
		
		/** cp1256 **/
		cp1256_bin,
		cp1256_general_ci,
		
		/** cp1257 **/
		cp1257_bin,
		cp1257_general_ci,
		cp1257_lithuanian_ci,
		
		/** cp850 **/
		cp850_bin,
		cp850_general_ci,
		
		/** cp852 **/
		cp852_bin,
		cp852_general_ci,
		
		/** cp866 **/
		cp866_bin, 
		cp866_general_ci,
		
		/** cp932 **/
		cp932_bin,
		cp932_japanese_ci,
		
		/** dec8 **/
		dec8_bin,
		dec8_swedish_ci,
		
		/** eucjpms **/
		eucjpms
		
		/** FINISH **/
	}
	
	public enum Index{
		PRIMARY,
		UNIQUE,
		INDEX, 
		FULLTEXT;
	}
	
	public enum Attributes{
		BINARY("BINARY"),
		UNSIGNED("UNSIGNED"),
		UNSIGNED_ZEROFILL("UNSIGNED ZEROFILL"),
		UPDATE_CURRENT_TIMESTAMP("on update CURRENT_TIMESTAMP");
		
		private String sql;
		private Attributes(String sql) {
			this.sql = sql;
		}
		
		@Override
		public String toString() {
			return sql;
		}
	}
}

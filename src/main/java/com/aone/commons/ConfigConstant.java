package com.aone.commons;

import java.time.format.DateTimeFormatter;

public class ConfigConstant {
	
	/**
	 * DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	 */
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	public static final DateTimeFormatter UI_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static final DateTimeFormatter UI_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	public static final DateTimeFormatter MYSQL_DB_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	private ConfigConstant() {
		super();
	}
	
}

package com.aone.config.security.constant;

public enum RoleMatcher {
	ANY("or"),
	ALL("and"),
	CUSTOM("custom");
	
	private String value;
	
	

	private RoleMatcher(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
}

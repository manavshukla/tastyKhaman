package com.aone.corelibrary.constant;

public enum OrderByConstant {

	ASC("asc"),
	DESC("DESC"),
	;
	
	private String value;

	private OrderByConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

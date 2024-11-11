package com.aone.commons;

public enum InOutWardConstant {
	
	// PURCHASE CONSTANT
	PURCHASE("PURCHASE"),
	PURCHASE_RETURN("PURCHASE_RETURN"),
	
	SALE("SALE"),
	SALE_RETURN("SALE_RETURN"),
	;
	
	private String value;

	private InOutWardConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

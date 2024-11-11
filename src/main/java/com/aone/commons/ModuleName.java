package com.aone.commons;

public enum ModuleName {
	
	CONTACT_BILLING_ADDRESS("CONTACT_BILLING_ADDRESS"),
	CONTACT_SHIPPING_ADDRESS("CONTACT_SHIPPING_ADDRESS"),
	SALES_SHIPPING_ADDRESS("SALES_SHIPPING_ADDRESS"),
	;
	
	private String value;

	private ModuleName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

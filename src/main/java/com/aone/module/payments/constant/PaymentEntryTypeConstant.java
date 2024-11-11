package com.aone.module.payments.constant;

public enum PaymentEntryTypeConstant {
	SALES("Sales"),
	PURCHASE("Purchase");
	
	private String value;

	private PaymentEntryTypeConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

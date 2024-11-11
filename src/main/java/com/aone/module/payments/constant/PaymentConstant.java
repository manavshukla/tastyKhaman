package com.aone.module.payments.constant;

public enum PaymentConstant {
	CREDIT(1),
	DEBIT(2);
	
	private int value;

	private PaymentConstant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

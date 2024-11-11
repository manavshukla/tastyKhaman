package com.aone.module.item.constant;

import java.util.HashMap;
import java.util.Map;

public enum OrderTypeItemConstant {

	LIVE_FOOD("Live Food Orders"),
	WHOLE_SALE("Whole Sales"),
	DAILY_FOOD_COUNTER("Daily Live Counter"),
	ROW_MATERIAL("Raw Material"),
	;
	
	private String value;
	private static Map<String, OrderTypeItemConstant> orderTypeWiseMap = new HashMap<>();

	private OrderTypeItemConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static OrderTypeItemConstant getOrderType(String value) {
		return orderTypeWiseMap.get(value);
	}
	
}

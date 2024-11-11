package com.aone.module.sales.constant;

import java.util.HashMap;
import java.util.Map;

public enum SalesOrderTypeEnum {
	
	LIVE_FOOD_ORDER(1),
	WHOLE_SALE_ORDER(2),
	DAILY_ORDER(3),
	;
	
	private int value;
	
	private static Map<Integer, SalesOrderTypeEnum> saleOrderTypeMap = new HashMap<>();
	
	static {
		for(SalesOrderTypeEnum orderTypeEnum : values()) {
			saleOrderTypeMap.put(orderTypeEnum.value, orderTypeEnum);
		}
	}

	private SalesOrderTypeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static SalesOrderTypeEnum getOrderType(int value) {
		return saleOrderTypeMap.get(value);
	}
}

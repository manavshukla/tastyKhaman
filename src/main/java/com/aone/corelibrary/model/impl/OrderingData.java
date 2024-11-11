package com.aone.corelibrary.model.impl;

import java.io.Serializable;

public class OrderingData implements Serializable {
	
	private static final long serialVersionUID = -1221298942739703669L;

	private String column;
	
	private boolean descending;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public boolean isDescending() {
		return descending;
	}

	public void setDescending(boolean descending) {
		this.descending = descending;
	}

	@Override
	public String toString() {
		return "OrderingData [column=" + column + ", descending=" + descending + "]";
	}
	
}

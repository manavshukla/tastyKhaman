package com.aone.corelibrary.model.impl;

import java.io.Serializable;

public class SearchData<T> implements Serializable {

	private static final long serialVersionUID = 9171438779602610486L;
	
	private OrderingData orderingData;
	private PaginationData paginationData;
	private T data;

	public OrderingData getOrderingData() {
		return orderingData;
	}

	public void setOrderingData(OrderingData orderingData) {
		this.orderingData = orderingData;
	}

	public PaginationData getPaginationData() {
		return paginationData;
	}

	public void setPaginationData(PaginationData paginationData) {
		this.paginationData = paginationData;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SearchData [orderingData=" + orderingData + ", paginationData=" + paginationData + "]";
	}

}

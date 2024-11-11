package com.aone.corelibrary.model.impl;

import java.io.Serializable;
import java.util.List;

public class RequestData<T, K extends Serializable> {
	
	private T data;
	
	private List<T> dataList;
	
	private String requestToken;
	
	private String authToken;
	
	private PaginationData paginationData;
	
	private K id;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getRequestToken() {
		return requestToken;
	}

	public void setRequestToken(String requestToken) {
		this.requestToken = requestToken;
	}
	
	public PaginationData getPaginationData() {
		return paginationData;
	}

	public void setPaginationData(PaginationData paginationData) {
		this.paginationData = paginationData;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RequestData [data=" + data + ", dataList=" + dataList
				+ ", requestToken=" + requestToken + ", paginationData="
				+ paginationData + ", id=" + id + "]";
	}

}

package com.aone.corelibrary.model;

import java.util.List;

public interface IResponseData<T> extends IBaseResponse {

	public T getData();

	public void setData(T data);

	public List<T> getDataList();

	public void setDataList(List<T> dataList);
	
	public long getTotalRecords();

	public void setTotalRecords(long totalRecords);

}

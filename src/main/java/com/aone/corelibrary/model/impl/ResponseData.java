package com.aone.corelibrary.model.impl;

import java.util.List;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;


// TODO: Auto-generated Javadoc
/**
 * The Class ResponseData.
 *
 * @author bharat tulsiyani
 * @param <T> the generic type
 */
public class ResponseData<T> extends BaseResponse implements IResponseData<T> {

	/** The data. */
	private T data;
	
	/** The data list. */
	private List<T> dataList;
	
	private long totalRecords;
	
	public ResponseData(ResultCodeConstant resultCodeConstant, String message) {
		super(resultCodeConstant, message, "requestToken");
	}
	
	/**
	 * Instantiates a new response data.
	 *
	 * @param data the data
	 * @param resultCodeConstant the result code constant
	 */
	public ResponseData(T data, ResultCodeConstant resultCodeConstant) {
		super(resultCodeConstant, "requestToken");
		this.data = data;
	}
	
	/**
	 * Instantiates a new response data.
	 *
	 * @param dataList the data list
	 * @param resultCodeConstant the result code constant
	 */
	public ResponseData(List<T> dataList, ResultCodeConstant resultCodeConstant) {
		super(resultCodeConstant, "requestToken");
		this.dataList = dataList;
	}
	
	/**
	 * Instantiates a new response data.
	 *
	 * @param data the data
	 * @param resultCodeConstant the result code constant
	 * @param responseMessage the response message
	 */
	public ResponseData(T data, ResultCodeConstant resultCodeConstant, String responseMessage) {
		super(resultCodeConstant, responseMessage, "requestToken");
		this.data = data;
	}
	
	/**
	 * Instantiates a new response data.
	 *
	 * @param dataList the data list
	 * @param resultCodeConstant the result code constant
	 * @param responseMessage the response message
	 */
	public ResponseData(List<T> dataList, ResultCodeConstant resultCodeConstant, String responseMessage) {
		super(resultCodeConstant, responseMessage, "requestToken");
		this.dataList = dataList;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IResponseData#getData()
	 */
	@Override
	public T getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IResponseData#setData(java.lang.Object)
	 */
	@Override
	public void setData(T data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IResponseData#getDataList()
	 */
	@Override
	public List<T> getDataList() {
		return dataList;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IResponseData#setDataList(java.util.List)
	 */
	@Override
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IResponseData#getTotalRecords()
	 */
	@Override
	public long getTotalRecords() {
		return totalRecords;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IResponseData#setTotalRecords(long)
	 */
	@Override
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.impl.BaseResponse#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "ResponseData [data=" + data + ", dataList=" + dataList
				+ ", totalRecords=" + totalRecords + "]";
	}

}

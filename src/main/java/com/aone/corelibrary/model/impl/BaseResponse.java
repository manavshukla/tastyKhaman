package com.aone.corelibrary.model.impl;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IBaseResponse;

/**
 * The Class BaseResponse.
 * @author bharat tulsiyani
 */
public class BaseResponse implements IBaseResponse {
	
	/** The response code. */
	private Integer responseCode;
	
	/** The response message. */
	private String responseMessage;
	
	/** The request token. */
	private String requestToken;
	
	/**
	 * Instantiates a new base response.
	 *
	 * @param resultCodeConstant the result code constant
	 * @param responseMessage the response message
	 * @param requestToken the request token
	 */
	public BaseResponse(ResultCodeConstant resultCodeConstant, String responseMessage, String requestToken) {
		super();
		this.responseCode = resultCodeConstant.getResultCode();
		this.responseMessage = responseMessage;
		this.requestToken = requestToken;
	}

	/**
	 * Instantiates a new base response.
	 *
	 * @param resultCodeConstant the result code constant
	 * @param requestToken the request token
	 */
	public BaseResponse(ResultCodeConstant resultCodeConstant, String requestToken) {
		super();
		this.responseCode = resultCodeConstant.getResultCode();
		this.responseMessage = resultCodeConstant.getMessage();
		this.requestToken = requestToken;
	}
	
	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IBaseResponse#getResponseCode()
	 */
	public Integer getResponseCode() {
		return responseCode;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IBaseResponse#setResponseCode(java.lang.Integer)
	 */
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IBaseResponse#getResponseMessage()
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IBaseResponse#setResponseMessage(java.lang.String)
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IBaseResponse#getRequestToken()
	 */
	public String getRequestToken() {
		return requestToken;
	}
	
	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.IBaseResponse#setRequestToken(java.lang.String)
	 */
	public void setRequestToken(String requestToken) {
		this.requestToken = requestToken;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseResponse [responseCode=" + responseCode
				+ ", responseMessage=" + responseMessage + ", requestToken="
				+ requestToken + "]";
	}
	
}

package com.aone.corelibrary.model.impl;

import com.aone.corelibrary.constant.ResultCodeConstant;

/**
 * The Class ErrorResponse.
 * 
 * @author bharat tulsiyani
 */
public class ErrorResponse extends BaseResponse {
	
	/** The error data. */
	private String errorData;

	/**
	 * Instantiates a new error response.
	 *
	 * @param resultCodeConstant the result code constant
	 * @param requestToken the request token
	 * @param errorData the error data
	 */
	public ErrorResponse(ResultCodeConstant resultCodeConstant,	String requestToken, String errorData) {
		super(resultCodeConstant, requestToken);
		this.errorData = errorData;
	}
	
	/**
	 * Instantiates a new error response.
	 *
	 * @param resultCodeConstant the result code constant
	 * @param message the message
	 * @param requestToken the request token
	 * @param errorData the error data
	 */
	public ErrorResponse(ResultCodeConstant resultCodeConstant, String message,	String requestToken, String errorData) {
		super(resultCodeConstant, message, requestToken);
		this.errorData = errorData;
	}

	/**
	 * Gets the error data.
	 *
	 * @return the error data
	 */
	public String getErrorData() {
		return errorData;
	}

	/**
	 * Sets the error data.
	 *
	 * @param errorData the new error data
	 */
	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}

	
	/* (non-Javadoc)
	 * @see com.aone.corelibrary.model.impl.BaseResponse#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "ErrorResponse [errorData=" + errorData + "]";
	}
	
}

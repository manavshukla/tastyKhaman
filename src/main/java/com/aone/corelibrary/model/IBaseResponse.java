package com.aone.corelibrary.model;

/**
 * The Interface IBaseResponse.
 * 
 * @author bharat tulsiyani
 */
public interface IBaseResponse {

	/**
	 * Gets the response code.
	 *
	 * @return the response code
	 */
	public Integer getResponseCode();

	/**
	 * Sets the response code.
	 *
	 * @param responseCode the new response code
	 */
	public void setResponseCode(Integer responseCode);

	/**
	 * Gets the response message.
	 *
	 * @return the response message
	 */
	public String getResponseMessage();

	/**
	 * Sets the response message.
	 *
	 * @param responseMessage the new response message
	 */
	public void setResponseMessage(String responseMessage);
	
	/**
	 * Gets the request token.
	 *
	 * @return the request token
	 */
	public String getRequestToken();

	/**
	 * Sets the request token.
	 *
	 * @param requestToken the new request token
	 */
	public void setRequestToken(String requestToken);
}

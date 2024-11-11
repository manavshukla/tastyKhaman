package com.aone.javax.servlet.filter.logging.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class LoggingResponse.
 * @author bharat tulsiyani
 */
public class LoggingResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6692682176015358216L;

	/** The status. */
	private int status;

	/** The headers. */
	private Map<String, String> headers;

	/** The body. */
	private String body;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * Sets the headers.
	 *
	 * @param headers the headers
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}
}

package com.aone.javax.servlet.filter.logging.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class LoggingRequest.
 * @author bharat tulsiyani
 */
public class LoggingRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4702574169916528738L;

	/** The sender. */
	private String sender;

	/** The method. */
	private String method;

	/** The path. */
	private String path;

	/** The params. */
	private Map<String, String> params;

	/** The headers. */
	private Map<String, String> headers;

	/** The body. */
	private String body;

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Sets the method.
	 *
	 * @param method the new method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the params.
	 *
	 * @return the params
	 */
	public Map<String, String> getParams() {
		return params;
	}

	/**
	 * Sets the params.
	 *
	 * @param params the params
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
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

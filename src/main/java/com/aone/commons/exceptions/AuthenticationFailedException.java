package com.aone.commons.exceptions;

public class AuthenticationFailedException extends RuntimeException {

	private static final long serialVersionUID = 8799356759060994395L;

	public AuthenticationFailedException(String message) {
		super(message);
	}

	public AuthenticationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticationFailedException(Throwable cause) {
		super(cause);
	}

	protected AuthenticationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
